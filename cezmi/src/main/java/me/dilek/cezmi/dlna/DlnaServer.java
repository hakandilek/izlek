package me.dilek.cezmi.dlna;

import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.meta.DeviceIdentity;
import org.fourthline.cling.model.meta.RemoteDevice;
import org.fourthline.cling.model.types.UDN;

/**
 * DLNA Server
 * <p/>
 * Created by Hakan Dilek on 19.04.15.
 */
public class DlnaServer {
    private final DeviceIdentity identity;
    private Device device;

    public DlnaServer(RemoteDevice device) {
        this.device = device;
        this.identity = device.getIdentity();
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
        final StringBuilder sb = new StringBuilder("DlnaServer{");
        sb.append("identity=").append(identity);
        sb.append('}');
        return sb.toString();
    }

    public Device getDevice() {
        return device;
    }

    public String getDeviceUdn() {
        UDN udn = identity.getUdn();
        return udn.toString();
    }
}
