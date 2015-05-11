package me.dilek.cezmi.domain;

/**
 * Persists {@link FileScan} instances
 * <p/>
 * Created by Hakan Dilek on 06.05.15.
 */
public interface FileScanRepository {
    FileScan createNewScan();

    void shutdown();

    FileScanItem saveItem(FileScanItem scanItem);

    FileScan saveScan(FileScan fileScan);
}
