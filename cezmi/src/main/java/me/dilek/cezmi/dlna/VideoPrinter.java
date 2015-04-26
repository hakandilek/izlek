package me.dilek.cezmi.dlna;

import org.fourthline.cling.support.model.item.VideoItem;

/**
 * Prints found video files
 * Created by Hakan Dilek on 21.04.15.
 */
public class VideoPrinter extends VideoObserver {

    @Override
    protected void videoFound(ContentPath path, VideoItem item) {
        System.out.println("video = " + item.getTitle());
    }

}
