package me.dilek.izlek.ui.view;

import android.content.Context;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import me.dilek.cezmi.domain.Episode;

/**
 * @author Hakan Dilek on 13.04.2015.
 */
@EBean
public class EpisodeListAdapter extends AbstractListAdapter<Episode> {

    @RootContext
    Context context;

    @Override
    protected AbstractItemView<Episode> getItemView() {
        return EpisodeItemView_.build(context);
    }
}
