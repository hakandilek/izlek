package me.dilek.cezmi.dlna;

import org.fourthline.cling.support.model.container.Container;
import org.fourthline.cling.support.model.item.Item;

/**
 * Created by Hakan Dilek on 21.04.15.
 */
public class ContentPrinter implements ContentObserver {
    @Override
    public void contentBrowsed(Content content) {
        System.out.println("content = " + content);
    }

    @Override
    public void itemFound(String path, Item item) {
        System.out.println(new StringBuilder("item = [").append(item.getId()).append("] ").append(path).append("/").append(item.getTitle()));
    }

    @Override
    public void containerBrowsed(String path, Container container) {
        System.out.println(new StringBuilder("container = [").append(container.getId()).append("] ").append(path).append("/").append(container.getTitle()));
    }
}
