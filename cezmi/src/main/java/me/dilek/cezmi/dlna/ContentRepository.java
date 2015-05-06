package me.dilek.cezmi.dlna;

import org.fourthline.cling.DefaultUpnpServiceConfiguration;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.UpnpServiceConfiguration;
import org.fourthline.cling.UpnpServiceImpl;
import org.fourthline.cling.controlpoint.ControlPoint;

import java.util.concurrent.ExecutorService;

/**
 * Facade class for content operations
 * Created by Hakan Dilek on 26.04.15.
 */
public class ContentRepository {

    private final ServerLocator locator;
    private final UpnpService upnpService;
    private final ControlPoint controlPoint;
    private final ServerContentScanner serverObserver;
    private final ContentScanner contentScanner;
    private int lastActive;

    public ContentRepository() {
        locator = new ServerLocator();
        upnpService = new UpnpServiceImpl(locator);

        // Send a search message to all devices and services, they should respond soon
        controlPoint = upnpService.getControlPoint();

        serverObserver = new ServerContentScanner(controlPoint);
        contentScanner = serverObserver.getContentScanner();
        locator.addServerObserver(serverObserver);
    }

    public static ContentRepository create() {
        return new ContentRepository();
    }

    public void clear() {
        //shutdown && cleanup
        upnpService.shutdown();
        locator.removeServerObserver(serverObserver);
        contentScanner.clear();
    }

    private ContentRepository addObserver(ContentObserver observer) {
        contentScanner.addContentObserver(observer);
        return this;
    }

    public ContentRepository search() {
        lastActive = activeThreadCount();
        System.out.println("lastActive = " + lastActive);
        controlPoint.search();
        return this;
    }

    private boolean isSearching() {
        int activeCount = activeThreadCount();
        System.out.println("activeCount = " + activeCount);
        //return activeCount > lastActive;
        return contentScanner.isBrowsing();
    }

    private int activeThreadCount() {
        UpnpServiceConfiguration config = controlPoint.getConfiguration();
        ExecutorService executorService = config.getSyncProtocolExecutorService();
        DefaultUpnpServiceConfiguration.ClingExecutor es = (DefaultUpnpServiceConfiguration.ClingExecutor) executorService;
        return es.getActiveCount();
    }

    public static void main(String[] args) throws InterruptedException, VideoCollectorCreatingException {
        VideoPrinter printer = new VideoPrinter();
        VideoCollector collector = VideoCollector.forCommon();

        ContentRepository repo = ContentRepository.create();
        repo.addObserver(printer);
        repo.addObserver(collector);
        repo.search();
        Thread.sleep(10 * 1000);

        do {
            // sleep for 1 more sec
            Thread.sleep(100);
        }
        while (repo.isSearching());

        //hang around for a while
        //Thread.sleep(5 * 1000);

        System.out.println("search finished, stopping!");

        repo.clear();
    }

}
