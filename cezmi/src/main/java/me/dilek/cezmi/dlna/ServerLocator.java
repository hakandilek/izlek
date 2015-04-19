package me.dilek.cezmi.dlna;

import org.fourthline.cling.UpnpService;
import org.fourthline.cling.UpnpServiceImpl;
import org.fourthline.cling.model.meta.RemoteDevice;
import org.fourthline.cling.registry.DefaultRegistryListener;
import org.fourthline.cling.registry.Registry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakan Dilek on 14.04.15.
 */
public class ServerLocator extends DefaultRegistryListener implements ServerObserver {

    private List<ServerObserver> observers;
    private List<DlnaServer> currentServers;

    public ServerLocator() {
        this.observers = new ArrayList<>();
        this.currentServers = new ArrayList<>();
        this.addServerObserver(this);
    }

    public void addServerObserver(ServerObserver o) {
        if (o != this)
            observers.add(o);
    }

    public void removeServerObserver(ServerObserver o) {
        if (o != this)
            observers.remove(o);
    }

    public synchronized List<DlnaServer> currentServers() {
        return currentServers;
    }

    @Override
    public void remoteDeviceAdded(Registry registry, RemoteDevice device) {
        notifyServerAdded(new DlnaServer(device));
    }

    @Override
    public void remoteDeviceRemoved(Registry registry, RemoteDevice device) {
        notifyServerRemoved(new DlnaServer(device));
    }

    private void notifyServerAdded(DlnaServer server) {
        for (ServerObserver observer : observers) {
            observer.serverAdded(server);
        }
    }

    private void notifyServerRemoved(DlnaServer server) {
        for (ServerObserver observer : observers) {
            observer.serverRemoved(server);
        }
    }

    @Override
    public void serverRemoved(DlnaServer server) {
        synchronized (this) {
            currentServers.remove(server);
        }
    }

    @Override
    public void serverAdded(DlnaServer server) {
        synchronized (this) {
            currentServers.add(server);
        }
    }


    public static final void main(String[] args) throws InterruptedException {

        // This will create necessary network resources for UPnP right away
        System.out.println("Starting Cling...");
        ServerLocator locator = new ServerLocator();
        locator.addServerObserver(new ServerObserver() {
            @Override
            public void serverRemoved(DlnaServer server) {
                System.out.println("server rmv = " + server);
            }

            @Override
            public void serverAdded(DlnaServer server) {
                System.out.println("server add = " + server);
            }
        });
        UpnpService upnpService = new UpnpServiceImpl(locator);

        // Send a search message to all devices and services, they should respond soon
        upnpService.getControlPoint().search();

        // Let's wait 10 seconds for them to respond
        System.out.println("Waiting 10 seconds before shutting down...");
        Thread.sleep(30000);

        // Release all resources and advertise BYEBYE to other UPnP devices
        System.out.println("Stopping Cling...");
        upnpService.shutdown();

    }

}
