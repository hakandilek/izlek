package me.dilek.izlek.ui.renderer;

import android.view.LayoutInflater;

import com.pedrogomez.renderers.RendererAdapter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.SystemService;

import me.dilek.izlek.domain.TvShow;

/**
 * Created by Hakan Dilek on 11.04.15.
 */
@EBean(scope = EBean.Scope.Singleton)
public class TvShowRendererAdapterFactory {

    @SystemService
    LayoutInflater layoutInflater;

    @Bean
    TvShowRendererBuilder rendererBuilder;

    public RendererAdapter<TvShow> getTvShowRendererAdapter(TvShowCollection tvShows) {
        return new RendererAdapter<>(layoutInflater, rendererBuilder, tvShows);
    }
}
