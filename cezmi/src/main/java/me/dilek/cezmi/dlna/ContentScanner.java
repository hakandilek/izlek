package me.dilek.cezmi.dlna;

import com.google.common.base.Supplier;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import org.fourthline.cling.controlpoint.ControlPoint;
import org.fourthline.cling.model.action.ActionException;
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
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;

import static com.google.common.collect.Multimaps.newSortedSetMultimap;

/**
 * Content scanner, scans content on a dlna server.
 * <p/>
 * Created by Hakan Dilek on 14.04.15.
 */
public class ContentScanner {

    private final List<ContentObserver> observers;
    private final Multimap<String, String> browseDirs;
    private ControlPoint controlPoint;

    public ContentScanner(ControlPoint controlPoint) {
        this.controlPoint = controlPoint;
        this.observers = new ArrayList<>();
        Supplier<? extends SortedSet<String>> supplier = new Supplier<SortedSet<String>>() {
            @Override
            public SortedSet<String> get() {
                return Sets.newTreeSet();
            }
        };
        this.browseDirs = newSortedSetMultimap(new TreeMap<String, Collection<String>>(), supplier);
    }

    public void addContentObserver(ContentObserver o) {
        if (o != this)
            observers.add(o);
    }

    public void scan(DlnaServer server) {
        Device device = server.getDevice();
        Service contentService = device.findService(new UDAServiceType("ContentDirectory"));
        if (contentService != null) {
            System.out.println("contentService = " + contentService.getDevice());
            ContentPath rootPath = ContentPath.createRoot(server.getDeviceUdn());
            browse(contentService, rootPath, "0");
        }
    }

    private void browse(final Service service, final ContentPath path, final String directoryId) {
        Browse browse = new Browse(service, directoryId, BrowseFlag.DIRECT_CHILDREN, "*", 0, 8192L, new SortCriterion(true, "dc:title")) {
            @Override
            public void received(ActionInvocation actionInvocation, DIDLContent content) {
                List<Item> items = content.getItems();
                List<Container> containers = content.getContainers();
                //System.out.println( directoryId + " = " + items.size() + "/" + containers.size());
                for (Item item : items) {
                    notifyItemFound(path, item);
                }
                for (Container container : containers) {
                    notifyContainerFound(path, container);
                    String containerId = container.getId();
                    String containerTitle = container.getTitle();
                    ContentPath containerPath = path.append(containerId, containerTitle);
                    //System.out.println(directoryId + " / (" + containerId +  ")" + containerTitle);
                    browse(service, containerPath, containerId);
                }
            }

            @Override
            public void updateStatus(Status status) {

                switch (status) {
                    case LOADING:
                        break;
                    case OK:
                    case NO_CONTENT:
                        synchronized (browseDirs) {
                            //System.out.println(directoryId + "-- " + browseDirs);
                            browseDirs.remove(path.getServer(), directoryId);
                        }
                        break;
                }

            }

            @Override
            public void failure(ActionInvocation invocation, UpnpResponse operation, String defaultMsg) {
                synchronized (browseDirs) {
                    ActionException failure = invocation.getFailure();
                    if (failure != null) failure.printStackTrace();
                    //System.out.println(directoryId + "-- " + browseDirs);
                    browseDirs.remove(path.getServer(), directoryId);
                }
            }
        };
        synchronized (browseDirs) {
            //System.out.println(directoryId + " -> " + browseDirs);
            browseDirs.put(path.getServer(), directoryId);
        }
        controlPoint.execute(browse);
    }

    private void notifyContainerFound(ContentPath path, Container container) {
        synchronized (observers) {
            for (ContentObserver observer : observers) {
                observer.containerFound(path, container);
            }
        }
    }

    private void notifyItemFound(ContentPath path, Item item) {
        synchronized (observers) {
            for (ContentObserver observer : observers) {
                observer.itemFound(path, item);
            }
        }
    }

    public void clear() {
        synchronized (browseDirs) {
            browseDirs.clear();
        }
        synchronized (observers) {
            for (ContentObserver observer : observers) {
                observer.shutdown();
            }
            observers.clear();
        }
    }

    public boolean isBrowsing() {
        //System.out.println("browseDirs = " + browseDirs.size());
        return !browseDirs.isEmpty();
    }
}
