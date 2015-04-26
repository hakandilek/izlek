package me.dilek.cezmi.dlna;

import org.fourthline.cling.controlpoint.ControlPoint;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.UDAServiceType;
import org.fourthline.cling.support.contentdirectory.callback.Browse;
import org.fourthline.cling.support.model.BrowseFlag;
import org.fourthline.cling.support.model.DIDLContent;
import org.fourthline.cling.support.model.SortCriterion;
import org.fourthline.cling.support.model.container.Container;
import org.fourthline.cling.support.model.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Content scanner, scans content on a dlna server.
 * <p/>
 * Created by Hakan Dilek on 14.04.15.
 */
public class ContentScanner {

    private List<ContentObserver> observers;
    private ControlPoint controlPoint;

    public ContentScanner(ControlPoint controlPoint) {
        this.controlPoint = controlPoint;
        this.observers = new ArrayList<>();
    }

    public void addContentObserver(ContentObserver o) {
        if (o != this)
            observers.add(o);
    }

    public void scan(DlnaServer server) {
        Device device = server.getDevice();
        Service contentService = device.findService(new UDAServiceType("ContentDirectory"));
        if (contentService != null) {
            System.out.println("contentService = " + contentService);
            ContentPath rootPath = ContentPath.createRoot();
            browse(contentService, rootPath, "0");
        }
    }

    private void browse(final Service service, final ContentPath path, final String directoryId) {
        Browse browse = new Browse(service, directoryId, BrowseFlag.DIRECT_CHILDREN, "*", 0, null, new SortCriterion(true, "dc:title")) {
            @Override
            public void received(ActionInvocation actionInvocation, DIDLContent content) {
                List<Item> items = content.getItems();
                for (Item item : items) {
                    notifyItemFound(path, item);
                }
                List<Container> containers = content.getContainers();
                for (Container container : containers) {
                    notifyContainerFound(path, container);
                    String containerId = container.getId();
                    String containerTitle = container.getTitle();
                    browse(service, path.append(containerId, containerTitle), containerId);
                }
            }

            @Override
            public void updateStatus(Status status) {

            }

            @Override
            public void failure(ActionInvocation invocation, UpnpResponse operation, String defaultMsg) {

            }
        };
        controlPoint.execute(browse);
    }

    private void notifyContainerFound(ContentPath path, Container container) {
        for (ContentObserver observer : observers) {
            observer.containerFound(path, container);
        }
    }

    private void notifyItemFound(ContentPath path, Item item) {
        for (ContentObserver observer : observers) {
            observer.itemFound(path, item);
        }
    }

    public void clear() {
        observers.clear();
    }
}
