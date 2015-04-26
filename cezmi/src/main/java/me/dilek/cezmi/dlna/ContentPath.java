package me.dilek.cezmi.dlna;

import java.util.ArrayList;
import java.util.List;

/**
 * Indicates a content path with id's and
 * Created by Hakan Dilek on 26.04.15.
 */
public class ContentPath {

    private final StringBuilder namePath;

    private final List<String> idPath;

    private ContentPath() {
        idPath = new ArrayList<>();
        namePath = new StringBuilder();
    }

    public static ContentPath createRoot() {
        return new ContentPath();
    }

    public ContentPath append(String id, String name) {
        namePath.append("/").append(name);
        idPath.add(id);
        return this;
    }

    public String getNamePath() {
        return namePath.toString();
    }

    public List<String> getIdPath() {
        return idPath;
    }

    @Override
    public String toString() {
        return namePath.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContentPath)) return false;

        ContentPath that = (ContentPath) o;

        return idPath.equals(that.idPath) && namePath.equals(that.namePath);
    }

    @Override
    public int hashCode() {
        int result = namePath.hashCode();
        result = 31 * result + idPath.hashCode();
        return result;
    }
}
