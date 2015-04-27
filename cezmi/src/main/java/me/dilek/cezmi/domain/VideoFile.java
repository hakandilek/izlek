package me.dilek.cezmi.domain;

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

    @DatabaseField
    private String serverPath;

    @DatabaseField
    private String filename;

    @DatabaseField(indexName = "idx_server_file")
    private String server;

    @DatabaseField(indexName = "idx_server_file")
    private String parentKey;

    @DatabaseField(dataType = DataType.DATE_TIME)
    private Date created;

    @DatabaseField(dataType = DataType.DATE_TIME)
    private Date updated;

    public VideoFile(String server, String parentKey, String serverKey, String filename, String serverPath, Date created, Date updated) {
        this.server = server;
        this.parentKey = parentKey;
        this.serverKey = serverKey;
        this.filename = filename;
        this.serverPath = serverPath;
        this.created = created;
        this.updated = updated;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoFile)) return false;

        VideoFile videoFile = (VideoFile) o;

        if (!key.equals(videoFile.key)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }


}
