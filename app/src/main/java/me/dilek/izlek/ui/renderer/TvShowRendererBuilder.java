package me.dilek.izlek.ui.renderer;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import me.dilek.izlek.domain.TvShow;

/**
 * Renderer builder for a tv show
 * Created by Hakan Dilek on 11.04.15.
 */
@EBean
public class TvShowRendererBuilder extends RendererBuilder<TvShow> {

    public TvShowRendererBuilder() {
        //TODO: empty renderer prototypes
        super(new ArrayList<Renderer<TvShow>>());
    }

    @Override
    protected Class getPrototypeClass(TvShow content) {
        return TvShowRenderer.class;
    }
}
