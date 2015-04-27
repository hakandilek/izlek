package me.dilek.cezmi.domain;

import java.util.List;

/**
 * DAO definition for {@link me.dilek.cezmi.domain.VideoFile}
 * Created by Hakan Dilek on 27.04.15.
 */
public interface VideoFileRepository {
    VideoFile find(String serverKey, String parentKey, String id);

    VideoFile save(VideoFile file, List<String> serverKeyPath);
}
