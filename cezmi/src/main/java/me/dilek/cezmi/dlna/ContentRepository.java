package me.dilek.cezmi.dlna;

import org.fourthline.cling.UpnpService;
import org.fourthline.cling.UpnpServiceImpl;
import org.fourthline.cling.controlpoint.ControlPoint;

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

    public ContentRepository() {
        locator = new ServerLocator();
        upnpService = new UpnpServiceImpl(locator);

        // Send a search message to all devices and services, they should respond soon
        controlPoint = upnpService.getControlPoint();

        serverObserver = new ServerContentScanner(controlPoint);
        contentScanner = serverObserver.getContentScanner();
        locator.addServerObserver(serverObserver);

        //start search
        controlPoint.search();
    }

    public void clear() {
        //shutdown && cleanup
        upnpService.shutdown();
        locator.removeServerObserver(serverObserver);
        contentScanner.clear();
    }

    public static ContentRepository create() {
        return new ContentRepository();
    }

    private ContentRepository addObserver(ContentObserver observer) {
        contentScanner.addContentObserver(observer);
        return this;
    }

    public ContentRepository search() {
        controlPoint.search();
        return this;
    }

    public static void main(String[] args) throws InterruptedException {
        VideoPrinter printer = new VideoPrinter();
        ContentRepository repo = ContentRepository.create().addObserver(printer).search();

        System.out.println("Waiting some time before shutting down...");
        Thread.sleep(30000);

        repo.clear();
    }

}
