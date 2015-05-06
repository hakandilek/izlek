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
    private final String server;

    private ContentPath(String server) {
        this(server, new ArrayList<String>(), new StringBuilder());
    }

    private ContentPath(String server, List<String> idPath, StringBuilder namePath) {
        this.server = server;
        this.idPath = idPath;
        this.namePath = namePath;
    }

    public static ContentPath createRoot(String server) {
        return new ContentPath(server);
    }

    public ContentPath append(String id, String name) {
        ContentPath cp = new ContentPath(server, idPath, namePath);
        cp.idPath.add(id);
        cp.namePath.append("/").append(name);
        return cp;
    }

    public String getNamePath() {
        return namePath.toString();
    }

    public List<String> getIdPath() {
        return idPath;
    }

    public String getServer() {
        return server;
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

        if (!idPath.equals(that.idPath)) return false;
        if (!namePath.equals(that.namePath)) return false;
        if (!server.equals(that.server)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = namePath.hashCode();
        result = 31 * result + idPath.hashCode();
        result = 31 * result + server.hashCode();
        return result;
    }
}
