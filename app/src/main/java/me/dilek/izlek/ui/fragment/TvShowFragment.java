package me.dilek.izlek.ui.fragment;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Set;

import me.dilek.izlek.R;
import me.dilek.cezmi.domain.Episode;
import me.dilek.izlek.ui.presenter.TvShowPresenter;
import me.dilek.izlek.ui.view.EpisodeListAdapter;
import me.dilek.izlek.util.ToastUtils;

@EFragment(R.layout.fragment_tv_show)
public class TvShowFragment extends Fragment implements TvShowPresenter.View {

    @Bean
    TvShowPresenter tvShowPresenter;

    @Bean
    EpisodeListAdapter adapter;

    private boolean useSaveInstanceState = true;

    @ViewById
    ImageView iv_fan_art;
    @ViewById
    ListView lv_episodes;
    @ViewById
    ProgressBar pb_loading;
    @ViewById
    View v_empty_case;

    private TextView header_tv_show_episodes;

    @AfterViews
    @Background
    public void initialize() {
        showEmptyCase(true);
        tvShowPresenter.setView(this);
        initializeListView();
    }

    void initializeListView() {
        header_tv_show_episodes = (TextView) LayoutInflater.from(getActivity())
                .inflate(R.layout.header_tv_show_episodes, null);
        lv_episodes.addHeaderView(header_tv_show_episodes);
        lv_episodes.setAdapter(adapter);
    }


    public void showTvShow(final String tvShowId) {
        if (isAdded()) {
            tvShowPresenter.loadTvShow(tvShowId);
        }
    }


    public void disableSaveInstanceState() {
        useSaveInstanceState = false;
    }

    @Override
    public void showLoading() {
        pb_loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void showFanArt(final String tvShowFanArtUrl) {
        iv_fan_art.setVisibility(View.VISIBLE);
        Picasso.with(getActivity())
                .load(tvShowFanArtUrl)
                .placeholder(R.color.main_color)
                .into(iv_fan_art);
    }

    @Override
    public void showTvShowTitle(final String tvShowTitle) {
        String tvShowHeaderTitle = getString(R.string.tv_show_title, tvShowTitle);
        header_tv_show_episodes.setText(tvShowHeaderTitle);
    }

    @Override
    public boolean isReady() {
        return isAdded();
    }

    @Override
    public boolean isAlreadyLoaded() {
        return adapter.getCount() > 0;
    }

    @Override
    public void showEpisodes(final Set<Episode> episodes) {
        adapter.clear();
        adapter.addAll(episodes);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void hideLoading() {
        pb_loading.setVisibility(View.GONE);
    }

    @Override
    public void showTvShowNotFoundMessage() {
        showEmptyCase(true);
        String tvShowNotFoundMessage = getString(R.string.tv_show_not_found);
        ToastUtils.showShortMessage(tvShowNotFoundMessage, getActivity());
    }

    @Override
    public void showConnectionErrorMessage() {
        showEmptyCase(true);
        String connectionErrorMessage = getString(R.string.connection_error_message);
        ToastUtils.showError(connectionErrorMessage, getActivity());
    }

    public void showEmptyCase(final boolean visible) {
        int visibility = visible ? View.VISIBLE : View.GONE;
        v_empty_case.setVisibility(visibility);
    }

    @Override
    public void showTvShow() {
        showEmptyCase(false);
    }

    /* TODO: save/restore state
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (useSaveInstanceState) {
            outState.putSerializable(EXTRA_TV_SHOW, tvShowPresenter.getCurrentTvShow());
        }
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            final TvShow tvShow = (TvShow) savedInstanceState.getSerializable(EXTRA_TV_SHOW);
            updatePresenterWithSavedTvShow(tvShow);
        }
    }

    private void updatePresenterWithSavedTvShow(final TvShow tvShow) {
        if (tvShow != null) {
            draggable_view.post(new Runnable() {
                @Override
                public void run() {
                    tvShowPresenter.loadTvShow(tvShow);
                }
            });
        }
    }
    */
}
