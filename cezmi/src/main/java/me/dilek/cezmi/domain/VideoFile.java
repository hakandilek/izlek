package me.dilek.cezmi.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Defines a video file
 * <p/>
 * Created by Hakan Dilek on 27.04.15.
 */
@DatabaseTable(tableName = "VideoFile")
public class VideoFile {

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
    private long created;

    @DatabaseField
    private long updated;

    public VideoFile() {
    }

    public VideoFile(String server, String parentKey, String serverKey, String filename, String serverPath, Date created, Date updated) {
        this.server = server;
        this.parentKey = parentKey;
        this.serverKey = serverKey;
        this.filename = filename;
        this.serverPath = serverPath;
        this.created = created != null ? created.getTime() : 0;
        this.updated = updated != null ? updated.getTime() : 0;
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

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public void setCreated(Date created) {
        this.created = created != null ? created.getTime() : 0;
    }

    public void setUpdated(Date updated) {
        this.updated = updated != null ? updated.getTime() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoFile)) return false;
        VideoFile videoFile = (VideoFile) o;
        return Objects.equal(key, videoFile.key) &&
                Objects.equal(serverKey, videoFile.serverKey) &&
                Objects.equal(server, videoFile.server) &&
                Objects.equal(parentKey, videoFile.parentKey);
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
                .add("updated", updated)
                .toString();
    }
}
