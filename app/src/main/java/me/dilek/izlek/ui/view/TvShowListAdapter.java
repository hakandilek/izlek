package me.dilek.izlek.ui.view;

import android.content.Context;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import me.dilek.izlek.domain.TvShow;

/**
 * @author Hakan Dilek on 13.04.2015.
 */
@EBean
public class TvShowListAdapter extends AbstractListAdapter<TvShow> {

    @RootContext
    Context context;

    @Override
    protected AbstractItemView<TvShow> getItemView() {
        return TvShowItemView_.build(context);
    }

}
