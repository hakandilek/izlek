package me.dilek.cezmi.dlna;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import org.fourthline.cling.support.model.item.VideoItem;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import me.dilek.cezmi.domain.VideoFile;
import me.dilek.cezmi.domain.VideoFileRepository;
import me.dilek.cezmi.domain.dao.VideoFileDao;

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

    public static VideoCollector forCommon() throws VideoCollectorCreatingException {
        try {
            ConnectionSource cs = new JdbcConnectionSource("jdbc:h2:./cezmi");
            prepareSchema(cs);
            VideoFileRepository repo = new VideoFileDao(cs);
            return new VideoCollector(repo);
        } catch (SQLException e) {
            throw new VideoCollectorCreatingException(e);
        }
    }

    private static void prepareSchema(ConnectionSource cs) throws SQLException {
        Class[] dataClasses = new Class[]{VideoFile.class};
        for (Class dataClass : dataClasses) {
            TableUtils.createTableIfNotExists(cs, dataClass);
        }
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

    @Override
    public void shutdown() {
        repository.shutdown();
    }
}
