package me.dilek.izlek.ui.renderer;

import android.view.LayoutInflater;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.SystemService;

/**
 * Created by Hakan Dilek on 12.04.15.
 */
@EBean(scope = EBean.Scope.Singleton)
public class EpisodeRendererAdapterFactory {

    @SystemService
    LayoutInflater layoutInflater;

    @Bean
    EpisodeRendererBuilder rendererBuilder;

    public EpisodeRendererAdapter getEpisodeRendererAdapter(
            final EpisodeCollection episodeCollection) {
        return new EpisodeRendererAdapter(layoutInflater, rendererBuilder, episodeCollection);
    }
}
