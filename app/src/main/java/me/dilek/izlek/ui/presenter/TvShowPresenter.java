package me.dilek.izlek.ui.presenter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.Set;

import me.dilek.izlek.domain.Catalog;
import me.dilek.cezmi.domain.Episode;
import me.dilek.cezmi.domain.TvShow;
import me.dilek.izlek.executor.LoadTask;
import me.dilek.izlek.executor.TaskRunner;

/**
 * Presenter implementation for a single tv show
 * Created by Hakan Dilek on 12.04.15.
 */
@EBean(scope = EBean.Scope.Singleton)
public class TvShowPresenter implements Presenter {

    @Bean
    TaskRunner executor;

    @Bean
    Catalog catalog;

    private TvShow currentTvShow;

    private View view;

    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public void setView(View view) {
        this.view = view;
    }

    public TvShow getCurrentTvShow() {
        return currentTvShow;
    }

    public void tvShowClosed() {
        currentTvShow = null;
    }

    public void loadTvShow(final TvShow tvShow) {
        showTvShow(tvShow);
    }

    public void loadTvShow(final String tvShowId) {
        view.showLoading();
        executor.run(new LoadTask<TvShow>() {
            @Override
            public TvShow load() throws Exception {
                return catalog.getTvShowById(tvShowId);
            }

            @Override
            public void onLoadSuccess(TvShow data) {
                showTvShow(data);
            }

            @Override
            public void onNotFound() {
                showTvShowNotFound();
            }

            @Override
            public void onError(Exception e) {
                showConnectionError();
            }
        });
    }

    @UiThread
    void showConnectionError() {
        if (view.isReady() && !view.isAlreadyLoaded()) {
            currentTvShow = null;
            view.hideLoading();
            view.showConnectionErrorMessage();
        }
    }

    @UiThread
    void showTvShowNotFound() {
        if (view.isReady()) {
            currentTvShow = null;
            view.hideLoading();
            view.showTvShowNotFoundMessage();
        }
    }

    @UiThread
    void showTvShow(TvShow tvShow) {
        if (view.isReady()) {
            currentTvShow = tvShow;
            view.showFanArt(tvShow.getFanArt());
            view.showTvShowTitle(tvShow.getTitle().toUpperCase());
            view.showEpisodes(tvShow.getEpisodes());
            view.hideLoading();
            view.showTvShow();
        }
    }

    /**
     * View interface created to abstract the view implementation used in this presenter.
     */
    public interface View {

        void showLoading();

        void showFanArt(final String tvShowFanArtUrl);

        void showEpisodes(final Set<Episode> episodes);

        void hideLoading();

        void showTvShowNotFoundMessage();

        void showConnectionErrorMessage();

        void showTvShow();

        void showTvShowTitle(String tvShowTitle);

        boolean isReady();

        boolean isAlreadyLoaded();
    }
}
