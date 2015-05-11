package me.dilek.cezmi.dlna;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import org.fourthline.cling.support.model.item.VideoItem;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import me.dilek.cezmi.domain.FileScan;
import me.dilek.cezmi.domain.FileScanItem;
import me.dilek.cezmi.domain.FileScanRepository;
import me.dilek.cezmi.domain.VideoFile;
import me.dilek.cezmi.domain.VideoFileRepository;
import me.dilek.cezmi.domain.dao.FileScanDao;
import me.dilek.cezmi.domain.dao.VideoFileDao;

/**
 * Collects and stores video files
 * <p/>
 * Created by Hakan Dilek on 21.04.15.
 */
public class VideoCollector extends VideoObserver {

    private final VideoFileRepository fileRepository;
    private final FileScanRepository scanRepository;
    private FileScan fileScan;

    public VideoCollector(VideoFileRepository fileRepository, FileScanRepository scanRepository) throws SQLException {
        this.fileRepository = fileRepository;
        this.scanRepository = scanRepository;
    }

    public static VideoCollector forCommon() throws VideoCollectorCreatingException {
        try {
            ConnectionSource cs = new JdbcConnectionSource("jdbc:h2:./cezmi");
            prepareSchema(cs);
            VideoFileRepository fileRepository = new VideoFileDao(cs);
            FileScanRepository fileScanRepository = new FileScanDao(cs);
            return new VideoCollector(fileRepository, fileScanRepository);
        } catch (SQLException e) {
            throw new VideoCollectorCreatingException(e);
        }
    }

    private static void prepareSchema(ConnectionSource cs) throws SQLException {
        Class[] dataClasses = new Class[]{VideoFile.class, FileScan.class, FileScanItem.class};
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
        Date now = new Date();

        Integer fileScanKey = fileScan.getKey();
        FileScanItem scanItem = new FileScanItem(serverKey, serverNamePath, title, server, parentKey, fileScanKey, now.getTime());
        VideoFile file = fileRepository.find(server, parentKey, serverKey);
        if (file == null) {
            file = new VideoFile(server, parentKey, serverKey, title, serverNamePath, now, now);
        } else {
            file.setUpdated(now);
        }
        file = fileRepository.save(file, serverKeyPath);
        scanItem.setVideoFileKey(file.getKey());
        scanRepository.saveItem(scanItem);
    }

    @Override
    public void start() {
        fileScan = scanRepository.createNewScan();
    }

    @Override
    public void shutdown() {
        fileScan = scanRepository.saveScan(fileScan);
        fileRepository.shutdown();
        scanRepository.shutdown();
    }
}
