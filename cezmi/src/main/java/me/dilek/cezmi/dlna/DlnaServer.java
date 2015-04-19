package me.dilek.cezmi.dlna;

import org.fourthline.cling.model.meta.DeviceIdentity;
import org.fourthline.cling.model.meta.RemoteDevice;

/**
 * Created by Hakan Dilek on 19.04.15.
 */
public class DlnaServer {
    private final DeviceIdentity identity;

    public DlnaServer(RemoteDevice device) {
        identity = device.getIdentity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DlnaServer)) return false;

        DlnaServer that = (DlnaServer) o;

        if (!identity.equals(that.identity)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return identity.hashCode();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DlnaServer{");
        sb.append("identity=").append(identity);
        sb.append('}');
        return sb.toString();
    }
}
