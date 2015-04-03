package me.dilek.izlek.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class EpisodeCollection implements Iterable<Episode>, Serializable {

    private static final long serialVersionUID = 3043259606994327229L;

    private final Set<Episode> episodes;

    public EpisodeCollection() {
        this.episodes = new LinkedHashSet<>();
    }

    @SuppressWarnings("unchecked")
    public Collection<Episode> getEpisodes() {
        return (Collection<Episode>) ((LinkedHashSet<Episode>) episodes).clone();
    }

    public void add(Episode episode) {
        this.episodes.add(episode);
    }

    @Override
    public Iterator<Episode> iterator() {
        return episodes.iterator();
    }

    public void addEpisode(int number, String title, String publishDate) {
        episodes.add(new Episode(number, title, publishDate));
    }

}
