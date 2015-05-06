package me.dilek.cezmi.dlna;

import java.sql.SQLException;

/**
 * Exception creating a video collector
 * Created by Hakan Dilek on 03.05.15.
 */
public class VideoCollectorCreatingException extends Exception {
    public VideoCollectorCreatingException(SQLException e) {
        super(e);
    }
}
