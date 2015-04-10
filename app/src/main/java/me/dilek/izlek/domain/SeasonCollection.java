package me.dilek.izlek.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SeasonCollection implements Iterable<Season>, Serializable {

    private static final long serialVersionUID = -4364084422273324469L;

    private final List<Season> seasons;

    public SeasonCollection() {
        this.seasons = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    public Collection<Season> getSeasons() {
        return (Collection<Season>) ((ArrayList<Season>) seasons).clone();
    }

    public void add(Season season) {
        this.seasons.add(season);
    }

    @Override
    public Iterator<Season> iterator() {
        return seasons.iterator();
    }

    public void addEpisode(int season, int episode, String title,
                           String publishDate) {
        while (seasons.size() < season) {
            seasons.add(new Season(season));
        }
        Season s = seasons.get(season - 1);
        s.addEpisode(episode, title, publishDate);
    }
}
