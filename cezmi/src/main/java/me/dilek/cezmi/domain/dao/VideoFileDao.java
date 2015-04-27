package me.dilek.cezmi.domain.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import me.dilek.cezmi.domain.VideoFile;
import me.dilek.cezmi.domain.VideoFileRepository;

/**
 * DAO implementation for {@link me.dilek.cezmi.domain.VideoFile} based on {@link me.dilek.cezmi.domain.VideoFileRepository}
 * Created by Hakan Dilek on 27.04.15.
 */
public class VideoFileDao implements VideoFileRepository {

    final Dao<VideoFile, Integer> dao;
    final QueryBuilder<VideoFile, Integer> queryBuilder;

    public VideoFileDao(ConnectionSource connectionSource) throws SQLException {
        this.dao = DaoManager.createDao(connectionSource, VideoFile.class);
        queryBuilder =
                dao.queryBuilder();
    }

    @Override
    public VideoFile find(String server, String parentKey, String serverKey) {
        try {
            PreparedQuery<VideoFile> query = queryBuilder.where().eq("server", server).eq("parentKey", parentKey).eq("serverKey", serverKey).prepare();
            return dao.queryForFirst(query);
        } catch (SQLException e) {
            //TODO: log exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public VideoFile save(VideoFile file, List<String> serverKeyPath) {
        try {
            dao.createOrUpdate(file);
            //TODO: persist server key paths
        } catch (SQLException e) {
            //TODO: log exception
            e.printStackTrace();
        }
        return null;
    }
}
