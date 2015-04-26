package me.dilek.cezmi.dlna;

import org.fourthline.cling.controlpoint.ControlPoint;

/**
 * Content scanning Server Observer
 * Created by Hakan Dilek on 26.04.15.
 */
public class ServerContentScanner implements ServerObserver {

    private final ContentScanner contentScanner;

    public ServerContentScanner(ControlPoint controlPoint) {
        contentScanner = new ContentScanner(controlPoint);
    }

    @Override
    public void serverRemoved(DlnaServer server) {
        // ignore this
    }

    @Override
    public void serverAdded(DlnaServer server) {
        contentScanner.scan(server);
    }

    public ContentScanner getContentScanner() {
        return contentScanner;
    }
}
