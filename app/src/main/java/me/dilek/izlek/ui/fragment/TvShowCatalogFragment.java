package me.dilek.izlek.ui.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import me.dilek.izlek.R;
import me.dilek.izlek.domain.TvShow;
import me.dilek.izlek.util.ToastUtils;

@EFragment(R.layout.fragment_tv_shows)
public class TvShowCatalogFragment extends Fragment {

    private static final String EXTRA_TV_SHOW_CATALOG = "extra_tv_show_catalog";

    /* TODO: presenters
    TvShowCatalogPresenter tvShowCatalogPresenter;
    TvShowRendererAdapterFactory tvShowRendererAdapterFactory;

    private RendererAdapter<TvShow> adapter;
    private TvShowCollection tvShows = new TvShowCollection();

    */

    @ViewById
    public ProgressBar pb_loading;

    @ViewById
    public GridView gv_tv_shows;

    @ViewById
    public View v_empty_case;

    /*
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeGridView();
        tvShowCatalogPresenter.setView(this);
        tvShowCatalogPresenter.initialize();
    }

*/

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
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
    */

    public void hideLoading() {
        pb_loading.setVisibility(View.GONE);
    }

    public void showLoading() {
        pb_loading.setVisibility(View.VISIBLE);
    }

    /* TODO: rendering
    @Override
    public void renderVideos(final Collection<TvShow> tvShows) {
        this.tvShows.clear();
        this.tvShows.addAll(tvShows);
        refreshAdapter();
    }

    @Override
    public void updateTitleWithCountOfTvShows(final int counter) {
        String actionBarTitle = getString(R.string.app_name_with_chapter_counter, counter);
        getActivity().setTitle(actionBarTitle);
    }

    @Override
    public void showConnectionErrorMessage() {
        String connectionError = getString(R.string.connection_error_message);
        ToastUtils.showShortMessage(connectionError, getActivity());
    }

*/

    public void showEmptyCase() {
        v_empty_case.setVisibility(View.VISIBLE);
    }

    public void showDefaultTitle() {
        getActivity().setTitle(R.string.app_name);
    }

    public void showTvShowTitleAsMessage(TvShow tvShow) {
        ToastUtils.showShortMessage(tvShow.getTitle(), getActivity());
    }

    public boolean isReady() {
        return isAdded();
    }

    /* TODO: init/update/refresh
    @Override
    public boolean isAlreadyLoaded() {
        return adapter.getCount() > 0;
    }

    private void initializeGridView() {
        adapter = tvShowRendererAdapterFactory.getTvShowRendererAdapter(tvShows);
        gv_tv_shows.setAdapter(adapter);
    }

    private void updatePresenterWithSavedTvShow(TvShowCollection tvShowCollection) {
        if (tvShowCollection != null) {
            tvShowCatalogPresenter.loadCatalog(tvShowCollection);
        }
    }

    private void refreshAdapter() {
        adapter.notifyDataSetChanged();
    }
    */
}
