package me.dilek.izlek.ui.renderer;

import android.view.LayoutInflater;

import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;

import me.dilek.izlek.domain.Episode;

/**
 * Renderer adapter for an episode
 * <p/>
 * Created by Hakan Dilek on 12.04.15.
 */
public class EpisodeRendererAdapter extends RendererAdapter<Episode> {

    public EpisodeRendererAdapter(LayoutInflater layoutInflater, RendererBuilder rendererBuilder, AdapteeCollection<Episode> collection) {
        super(layoutInflater, rendererBuilder, collection);
    }


    @Override
    protected void updateRendererExtraValues(Episode content, Renderer<Episode> renderer,
                                             int position) {
        super.updateRendererExtraValues(content, renderer, position);
        ((EpisodeRenderer) renderer).setPosition(position);
    }
}
