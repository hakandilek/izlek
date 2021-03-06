package me.dilek.izlek.ui.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.Collection;

import me.dilek.izlek.R;
import me.dilek.cezmi.domain.TvShow;
import me.dilek.izlek.ui.presenter.TvShowCatalogPresenter;
import me.dilek.izlek.ui.view.TvShowListAdapter;
import me.dilek.izlek.util.ToastUtils;

@EFragment(R.layout.fragment_tv_shows)
public class TvShowCatalogFragment extends Fragment implements TvShowCatalogPresenter.View {

    private static final String EXTRA_TV_SHOW_CATALOG = "extra_tv_show_catalog";

    @Bean
    TvShowCatalogPresenter tvShowCatalogPresenter;

    @Bean
    TvShowListAdapter adapter;

    @ViewById
    ProgressBar pb_loading;

    @ViewById
    GridView gv_tv_shows;

    @ViewById
    View v_empty_case;

    @AfterViews
    @Background
    public void initialize() {
        // initialize GridView
        gv_tv_shows.setAdapter(adapter);
        // initialize presenter
        tvShowCatalogPresenter.setView(this);
        tvShowCatalogPresenter.initialize();
    }

    @UiThread
    public void renderVideos(Collection<TvShow> tvShows) {
        adapter.clear();
        adapter.addAll(tvShows);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void hideLoading() {
        pb_loading.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        pb_loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void updateTitleWithCountOfTvShows(int counter) {
        String actionBarTitle = getString(R.string.app_name_with_chapter_counter, counter);
        getActivity().setTitle(actionBarTitle);
    }

    @Override
    public void showConnectionErrorMessage() {
        String connectionError = getString(R.string.connection_error_message);
        ToastUtils.showShortMessage(connectionError, getActivity());
    }

    @Override
    public void showEmptyCase() {
        v_empty_case.setVisibility(View.VISIBLE);
    }

    @Override
    public void showDefaultTitle() {
        getActivity().setTitle(R.string.app_name);
    }

    @Override
    public boolean isReady() {
        return isAdded();
    }

    public void showTvShowTitleAsMessage(TvShow tvShow) {
        ToastUtils.showShortMessage(tvShow.getTitle(), getActivity());
    }

    @Override
    public boolean isAlreadyLoaded() {
        return adapter.getCount() > 0;
    }

    @ItemClick(R.id.gv_tv_shows)
    void onItemClicked(TvShow item) {
        tvShowCatalogPresenter.onTvShowThumbnailClicked(item);
    }

    /* TODO: resume/pause
    @Override
    public void onResume() {
        super.onResume();
        tvShowCatalogPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        tvShowCatalogPresenter.pause();
    }
    */

    /**
     * We want to keep the catalog loaded in this fragment even if the user rotates the device. We
     * are
     * using different configurations for landscape and portrait and we have to use this approach
     * instead of onConfigurationChanges.
     */

    /* TODO: resume/pause
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(EXTRA_TV_SHOW_CATALOG, tvShowCatalogPresenter.getCurrentTvShows());
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            final TvShowCollection tvShowCollection =
                    (TvShowCollection) savedInstanceState.getSerializable(EXTRA_TV_SHOW_CATALOG);
            updatePresenterWithSavedTvShow(tvShowCollection);
        }
    }
    private void updatePresenterWithSavedTvShow(TvShowCollection tvShowCollection) {
        if (tvShowCollection != null) {
            tvShowCatalogPresenter.loadCatalog(tvShowCollection);
        }
    }
    */
}
