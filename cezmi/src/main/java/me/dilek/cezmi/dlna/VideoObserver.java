package me.dilek.cezmi.dlna;

import org.fourthline.cling.support.model.container.Container;
import org.fourthline.cling.support.model.item.Item;
import org.fourthline.cling.support.model.item.VideoItem;

/**
 * Observes only video files
 * Created by Hakan Dilek on 26.04.15.
 */
public abstract class VideoObserver implements ContentObserver {
    @Override
    public void itemFound(ContentPath path, Item item) {
        if (item instanceof VideoItem) {
            videoFound(path, (VideoItem) item);
        }
    }

    protected abstract void videoFound(ContentPath path, VideoItem item);

    @Override
    public void containerFound(ContentPath path, Container container) {
        // just ignore
    }
}
