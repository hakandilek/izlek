package me.dilek.izlek.ui.renderer;

import java.util.Collection;

import me.dilek.izlek.domain.Episode;

/**
 * Episode collection for the renderer
 * <p/>
 * Created by Hakan Dilek on 12.04.15.
 */
public class EpisodeCollection extends BaseAdapteeCollection<Episode> {

    public EpisodeCollection() {
    }

    public EpisodeCollection(Collection<Episode> list) {
        super(list);
    }
}
