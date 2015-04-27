package me.dilek.cezmi.dlna;

import org.fourthline.cling.support.model.item.VideoItem;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import me.dilek.cezmi.domain.VideoFile;
import me.dilek.cezmi.domain.VideoFileRepository;

/**
 * Collects and stores video files
 * <p/>
 * Created by Hakan Dilek on 21.04.15.
 */
public class VideoCollector extends VideoObserver {

    private VideoFileRepository repository;

    public VideoCollector(VideoFileRepository repository) throws SQLException {
        this.repository = repository;
    }

    @Override
    protected void videoFound(ContentPath path, VideoItem item) {
        String serverKey = item.getId();
        String parentKey = item.getParentID();
        String title = item.getTitle();
        String server = path.getServer();
        List<String> serverKeyPath = path.getIdPath();
        String serverNamePath = path.getNamePath();

        VideoFile file = repository.find(server, parentKey, serverKey);
        Date now = new Date();
        if (file == null) {
            file = new VideoFile(server, parentKey, serverKey, title, serverNamePath, now, now);
        } else {
            file.setUpdated(now);
        }
        file = repository.save(file, serverKeyPath);

        System.out.println("saved file = " + file);
    }

}
