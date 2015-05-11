package me.dilek.cezmi.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Defines a DLNA file scan session
 * Created by Hakan Dilek on 06.05.15.
 */
@DatabaseTable(tableName = "FileScanItem")
public class FileScanItem {

    @DatabaseField(generatedId = true)
    private Integer key;

    @DatabaseField(indexName = "idx_server_file")
    private String serverKey;

    @DatabaseField(dataType = DataType.LONG_STRING, width = 2048)
    private String serverPath;

    @DatabaseField(dataType = DataType.LONG_STRING, width = 2048)
    private String filename;

    @DatabaseField(indexName = "idx_server_file")
    private String server;

    @DatabaseField(indexName = "idx_server_file")
    private String parentKey;

    @DatabaseField
    private Integer fileScanKey;

    @DatabaseField
    private Integer videoFileKey;

    @DatabaseField
    private long created;

    public FileScanItem() {
    }

    public FileScanItem(String serverKey, String serverPath, String filename, String server, String parentKey, Integer fileScanKey, long created) {
        this.serverKey = serverKey;
        this.serverPath = serverPath;
        this.filename = filename;
        this.server = server;
        this.parentKey = parentKey;
        this.fileScanKey = fileScanKey;
        this.created = created;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getServerKey() {
        return serverKey;
    }

    public void setServerKey(String serverKey) {
        this.serverKey = serverKey;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileScanItem)) return false;
        FileScanItem item = (FileScanItem) o;
        return Objects.equal(key, item.key) &&
                Objects.equal(serverKey, item.serverKey) &&
                Objects.equal(server, item.server) &&
                Objects.equal(parentKey, item.parentKey);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key, serverKey, server, parentKey);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("key", key)
                .add("server", server)
                .add("parentKey", parentKey)
                .add("serverKey", serverKey)
                .add("filename", filename)
                .add("created", created)
                .toString();
    }

    public void setVideoFileKey(Integer videoFileKey) {
        this.videoFileKey = videoFileKey;
    }

    public Integer getVideoFileKey() {
        return videoFileKey;
    }

    public Integer getFileScanKey() {
        return fileScanKey;
    }

    public void setFileScanKey(Integer fileScanKey) {
        this.fileScanKey = fileScanKey;
    }
}
