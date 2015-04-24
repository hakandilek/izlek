package me.dilek.cezmi.dlna;

import org.fourthline.cling.support.model.DIDLContent;

/**
 * Created by Hakan Dilek on 21.04.15.
 */
public class Content {
    private String directoryId;
    private String parentId;
    private DIDLContent didl;

    public Content(String directoryId, String parentId, DIDLContent didl) {
        this.directoryId = directoryId;
        this.parentId = parentId;
        this.didl = didl;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Content{");
        sb.append("directoryId='").append(directoryId).append('\'');
        sb.append(", parentId='").append(parentId).append('\'');
        sb.append(", didl=").append(didl);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Content)) return false;

        Content content = (Content) o;

        if (!didl.equals(content.didl)) return false;
        if (!directoryId.equals(content.directoryId)) return false;
        if (!parentId.equals(content.parentId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = directoryId.hashCode();
        result = 31 * result + parentId.hashCode();
        result = 31 * result + didl.hashCode();
        return result;
    }
}
