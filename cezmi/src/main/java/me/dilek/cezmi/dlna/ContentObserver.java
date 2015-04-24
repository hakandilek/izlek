package me.dilek.cezmi.dlna;

import org.fourthline.cling.support.model.container.Container;
import org.fourthline.cling.support.model.item.Item;

/**
 * Created by Hakan Dilek on 21.04.15.
 */
public interface ContentObserver {
    void contentBrowsed(Content content);

    void itemFound(String path, Item item);

    void containerBrowsed(String path, Container container);
}
