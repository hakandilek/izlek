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

import java.util.ArrayList;
import java.util.List;

/**
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

    public void removeContentObserver(ContentObserver o) {
        if (o != this)
            observers.remove(o);
    }

    public void scan(DlnaServer server) {
        Device device = server.getDevice();
        Service service = device.findService(new UDAServiceType("ContentDirectory"));
        browse(service, "0", null);
    }

    private void browse(Service service, final String directoryId, final String parentId) {
        //TODO: implement browse
        Browse browse = new Browse(service, directoryId, BrowseFlag.DIRECT_CHILDREN, "*", 0, null, new SortCriterion(true, "dc:title")) {
            @Override
            public void received(ActionInvocation actionInvocation, DIDLContent didl) {
                notifyContentBrowsed(directoryId, parentId, didl);
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

    private synchronized void notifyContentBrowsed(String directoryId, String parentId, DIDLContent didl) {
        Content content = new Content(directoryId, parentId, didl);
        for (ContentObserver observer : observers) {
            observer.contentBrowsed(content);
        }
    }
}
