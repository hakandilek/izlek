package me.dilek.izlek.ui.presenter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import me.dilek.izlek.domain.Catalog;
import me.dilek.izlek.domain.TvShow;
import me.dilek.izlek.executor.LoadTask;
import me.dilek.izlek.executor.TaskRunner;
import me.dilek.izlek.ui.activity.Navigator;

/**
 * @author Hakan.Dilek
 */
@EBean(scope = EBean.Scope.Singleton)
public class TvShowCatalogPresenter implements Presenter {

    @Bean
    Navigator navigator;

    @Bean
    TaskRunner executor;

    @Bean
    Catalog catalog;

    private View view;

    private List<TvShow> currentTvShows;

    public List<TvShow> getCurrentTvShows() {
        return currentTvShows;
    }

    public void setView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("You can't set a null view");
        }
        this.view = view;
    }

    private void checkView() {
        if (view == null) {
            throw new IllegalArgumentException("Remember to set a view for this presenter");
        }
    }

    @Override
    public void initialize() {
        checkView();
        loadTvShows();
    }

    @Override
    public void resume() {
        //Empty
    }

    @Override
    public void pause() {
        //Empty
    }

    /**
     * Used to force a TvShowCollection load in the presenter. This method is used by
     * TvShowCatalogFragment when the fragment lifecycle is restored and there are already loaded tv
     * shows.
     */
    public void loadCatalog(final List<TvShow> tvShows) {
        currentTvShows = tvShows;
        showTvShows(tvShows);
    }

    private void loadTvShows() {
        if (view.isReady()) {
            view.showLoading();
        }
        executor.run(new LoadTask<Set<TvShow>>() {
            @Override
            public Set<TvShow> load() {
                return catalog.getTvShows();
            }

            @Override
            public void onLoadSuccess(final Set<TvShow> tvShows) {
                currentTvShows = new ArrayList<>(tvShows);
                showTvShows(tvShows);
            }

            @Override
            public void onError(Exception e) {
                notifyConnectionError();
            }
        });
    }

    @UiThread
    void notifyConnectionError() {
        if (view.isReady() && !view.isAlreadyLoaded()) {
            view.hideLoading();
            view.showConnectionErrorMessage();
            view.showEmptyCase();
            view.showDefaultTitle();
        }
    }

    @UiThread
    void showTvShows(Collection<TvShow> tvShows) {
        if (view.isReady()) {
            view.renderVideos(tvShows);
            view.hideLoading();
            view.updateTitleWithCountOfTvShows(tvShows.size());
        }
    }

    public void onTvShowThumbnailClicked(final TvShow tvShow) {
        navigator.openTvShowDetails(tvShow);
    }

    public void onTvShowClicked(final TvShow tvShow) {
        view.showTvShowTitleAsMessage(tvShow);
    }


    public interface View {

        boolean isReady();

        void renderVideos(Collection<TvShow> tvShows);

        void hideLoading();

        void updateTitleWithCountOfTvShows(int size);

        void showLoading();

        boolean isAlreadyLoaded();

        void showConnectionErrorMessage();

        void showEmptyCase();

        void showDefaultTitle();

        void showTvShowTitleAsMessage(TvShow tvShow);
    }
}
