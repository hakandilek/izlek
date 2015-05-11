package me.dilek.cezmi.dlna;

import org.fourthline.cling.support.model.container.Container;
import org.fourthline.cling.support.model.item.Item;

/**
 * Content browser notifies this interface for content browse events
 * Created by Hakan Dilek on 21.04.15.
 */
public interface ContentObserver {

    void itemFound(ContentPath path, Item item);

    void containerFound(ContentPath path, Container container);

    void start();

    void shutdown();
}
