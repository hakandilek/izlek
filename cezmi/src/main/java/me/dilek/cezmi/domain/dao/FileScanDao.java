package me.dilek.cezmi.domain.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.Date;

import me.dilek.cezmi.domain.FileScan;
import me.dilek.cezmi.domain.FileScanItem;
import me.dilek.cezmi.domain.FileScanRepository;

/**
 * File Scan DAO
 * <p/>
 * Created by Hakan Dilek on 06.05.15.
 */
public class FileScanDao implements FileScanRepository {

    private final Dao<FileScan, Integer> fileScanDao;
    private final Dao<FileScanItem, Integer> fileScanItemDao;

    public FileScanDao(ConnectionSource connectionSource) throws SQLException {
        this.fileScanDao = DaoManager.createDao(connectionSource, FileScan.class);
        this.fileScanItemDao = DaoManager.createDao(connectionSource, FileScanItem.class);

    }

    @Override
    public FileScan createNewScan() {
        FileScan fileScan = new FileScan();
        fileScan.setStarted(new Date().getTime());
        try {
            fileScanDao.createOrUpdate(fileScan);
            return fileScan;
        } catch (SQLException e) {
            //TODO: log exception
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FileScanItem saveItem(FileScanItem scanItem) {
        try {
            fileScanItemDao.createOrUpdate(scanItem);
            return scanItem;
        } catch (SQLException e) {
            //TODO: log exception
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FileScan saveScan(FileScan fileScan) {
        try {
            fileScan.setFinished(new Date().getTime());
            return fileScan;
        } catch (Exception e) {
            //TODO: log exception
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void shutdown() {
        ConnectionSource connectionSource = fileScanDao.getConnectionSource();
        if (connectionSource != null && connectionSource.isOpen()) {
            try {
                connectionSource.close();
            } catch (SQLException e) {
                //TODO: log exception
                e.printStackTrace();
            }
        }
    }
}
