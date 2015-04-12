package me.dilek.izlek.ui.renderer;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import me.dilek.izlek.domain.Episode;

/**
 * Created by Hakan Dilek on 12.04.15.
 */
@EBean
public class EpisodeRendererBuilder extends RendererBuilder<Episode> {

    public EpisodeRendererBuilder() {
        //TODO: empty renderer prototypes
        super(new ArrayList<Renderer<Episode>>());
    }

    @Override
    protected Class getPrototypeClass(Episode content) {
        return EpisodeRenderer.class;
    }
}
