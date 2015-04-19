package me.dilek.cezmi.dlna;

/**
 * Created by Hakan Dilek on 19.04.15.
 */
public interface ServerObserver {
    void serverRemoved(DlnaServer server);

    void serverAdded(DlnaServer server);
}
