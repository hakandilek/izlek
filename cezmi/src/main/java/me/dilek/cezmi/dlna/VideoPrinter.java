package me.dilek.cezmi.dlna;

import org.fourthline.cling.support.model.Res;
import org.fourthline.cling.support.model.item.VideoItem;

import java.util.List;

/**
 * Prints found video files
 * Created by Hakan Dilek on 21.04.15.
 */
public class VideoPrinter extends VideoObserver {

    @Override
    protected void videoFound(ContentPath path, VideoItem item) {
        System.out.println("video = " /*+ path + " //// " */ + item.getTitle() + " @ " + res(item));
    }

    private String res(VideoItem item) {
        StringBuilder sb = new StringBuilder();
        List<Res> resources = item.getResources();
        for (Res res : resources) {
            if (sb.length() > 0)
                sb.append(", ");
            sb.append(res.getValue());
        }
        return sb.toString();
    }

    @Override
    public void shutdown() {
        // shutdown unnecessary
    }
}
