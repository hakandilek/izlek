package me.dilek.izlek.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class TvShow implements Watchable {

    private static final long serialVersionUID = 2456255612311267832L;

    private String title;
    private String poster;
    private String fanArt;
    private int numberOfSeasons;
    private final SeasonCollection seasons = new SeasonCollection();

    public TvShow(String title, String poster, String fanArt,
                  int numberOfSeasons) {
        super();
        this.title = title;
        this.poster = poster;
        this.fanArt = fanArt;
        this.numberOfSeasons = numberOfSeasons;
    }

    public TvShow() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getFanArt() {
        return fanArt;
    }

    public void setFanArt(String fanArt) {
        this.fanArt = fanArt;
    }

    public SeasonCollection getSeasons() {
        return seasons;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public void addEpisode(int season, int episode, String title, String publishDate) {
        seasons.addEpisode(season, episode, title, publishDate);
    }

    public Set<Episode> getEpisodes() {
        Set<Episode> episodes = new LinkedHashSet<>();
        for (Season season : seasons) {
            episodes.addAll(season.getEpisodes().getEpisodes());
        }
        return episodes;
    }

}
