package me.dilek.izlek.ui.renderer;

import java.util.Collection;

import me.dilek.izlek.domain.TvShow;

/**
 * @author Hakan Dilek on 10.04.2015.
 */
public class TvShowCollection extends BaseAdapteeCollection<TvShow> {
    public TvShowCollection() {
    }

    public TvShowCollection(Collection<TvShow> list) {
        super(list);
    }

}
