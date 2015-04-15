package me.dilek.cezmi.plugin;

import com.omertron.thetvdbapi.TheTVDBApi;
import com.omertron.thetvdbapi.model.Episode;
import com.omertron.thetvdbapi.model.Series;

import org.apache.commons.lang3.math.NumberUtils;
import org.pojava.datetime.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.common.http.CommonHttpClient;

import java.util.List;

import javax.inject.Inject;

import me.dilek.cezmi.domain.TvShow;
import me.dilek.cezmi.util.StringTools;

/**
 * @author Hakan Dilek on 15.04.2015.
 */
public class TheTvDBPlugin {

    private static final Logger LOG = LoggerFactory.getLogger(TheTvDBPlugin.class);
    private static final String DEFAULT_LANG = "en";

    final TheTVDBApi tvDb;

    @Inject
    public TheTvDBPlugin(String apiKey, CommonHttpClient httpClient) {
        this.tvDb = new TheTVDBApi(apiKey, httpClient);
    }

    public TvShow load(String name, String year) {
        TvShow result = null;
        String id = findId(name, year);
        if (StringTools.isNotEmpty(id)) {
            Series series = tvDb.getSeries(id, DEFAULT_LANG);
            if (series != null) {
                result = new TvShow();
                result.setTitle(series.getSeriesName());
                result.setPoster(series.getPoster());
                result.setFanArt(series.getBanner());
                List<Episode> episodes = tvDb.getAllEpisodes(id, DEFAULT_LANG);
                for (Episode ep : episodes) {
                    result.addEpisode(ep.getSeasonNumber(), ep.getEpisodeNumber(), ep.getEpisodeName(), ep.getFirstAired());
                }
            }
        }
        return result;
    }

    private String findId(String title, String year) {
        String result = null;
        List<Series> seriesList = tvDb.searchSeries(title, DEFAULT_LANG);
        if(seriesList != null) {
            Series series = null;
            for (Series s : seriesList) {
                if (StringTools.isNotEmpty(s.getFirstAired())) {
                    if (StringTools.isNotEmpty(year)) {
                        DateTime firstAired = DateTime.parse(s.getFirstAired());
                        if (NumberUtils.toInt(firstAired.toString("yyyy")) == NumberUtils.toInt(year)) {
                            series = s;
                            break;
                        }
                    } else {
                        series = s;
                        break;
                    }
                }
            }

            // If we can't find an exact match, select the first one
            if (series == null) {
                series = seriesList.get(0);
                LOG.debug("No exact match for {} found", title);
            }

            result = String.valueOf(series.getId());
        }
        return result;
    }
}
