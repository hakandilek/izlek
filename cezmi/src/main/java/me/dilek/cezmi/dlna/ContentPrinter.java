package me.dilek.cezmi.dlna;

/**
 * Created by Hakan Dilek on 21.04.15.
 */
public class ContentPrinter implements ContentObserver {
    @Override
    public void contentBrowsed(Content content) {
        System.out.println("content = " + content);
    }
}
