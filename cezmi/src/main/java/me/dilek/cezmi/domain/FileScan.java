package me.dilek.cezmi.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Defines a DLNA file scan session
 * Created by Hakan Dilek on 06.05.15.
 */
@DatabaseTable(tableName = "FileScan")
public class FileScan {

    @DatabaseField(generatedId = true)
    private Integer key;

    @DatabaseField
    private long started;

    @DatabaseField
    private long finished;

    public FileScan() {
    }

    public FileScan(Date started) {
        this.started = started.getTime();
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileScan)) return false;
        FileScan fileScan = (FileScan) o;
        return Objects.equal(key, fileScan.key) && Objects.equal(started, fileScan.started) &&
                Objects.equal(finished, fileScan.finished)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key, started, finished);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("key", key)
                .add("started", started)
                .add("finished", finished)
                .toString();
    }
}
