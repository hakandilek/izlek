package me.dilek.izlek.ui.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import me.dilek.izlek.R;
import me.dilek.izlek.domain.TvShow;
import me.dilek.izlek.ui.fragment.TvShowDraggableFragment;
import me.dilek.izlek.ui.fragment.TvShowFragment;

/**
 * Class to handle navigation between activities.
 *
 * @author Hakan Dilek on 10.04.2015.
 */
@EBean
public class Navigator {

    @RootContext
    Context activityContext;

    private TvShowFragment tvShowFragment;
    private TvShowDraggableFragment tvShowDraggableFragment;

    public void openTvShowDetails(TvShow tvShow) {

        if (canInteractWithFragments()) {
            showTvShowOnTvShowDraggableFragment(tvShow);
            showTvShowOnTvShowFragment(tvShow);
        } else {
            openTvShowActivity(tvShow.getTitle());
        }

    }


    private FragmentManager getFragmentManager() {
        return ((FragmentActivity) activityContext).getSupportFragmentManager();
    }

    private boolean canInteractWithFragments() {
        tvShowFragment = (TvShowFragment) getFragmentManager().findFragmentById(R.id.f_tv_show);
        tvShowDraggableFragment =
                (TvShowDraggableFragment) getFragmentManager().findFragmentById(R.id.f_tv_show_draggable);

        return tvShowDraggableFragment != null || tvShowFragment != null;
    }

    private void showTvShowOnTvShowDraggableFragment(TvShow tvShow) {
        if (isFragmentAvailable(tvShowDraggableFragment)) {
            tvShowDraggableFragment.showTvShow(tvShow.getTitle());
        }
    }

    private void showTvShowOnTvShowFragment(TvShow tvShow) {
        if (isFragmentAvailable(tvShowFragment)) {
            tvShowFragment.showTvShow(tvShow.getTitle());
        }
    }

    /**
     * Check if the fragment is ready to be notified of a new TvShow loaded.
     *
     * @return true if the Fragment instance is not null and is attached.
     */
    private boolean isFragmentAvailable(Fragment fragment) {
        return fragment != null && fragment.isAdded();
    }

    /**
     * Open TvShowActivity using a tvShowId.
     */
    public void openTvShowActivity(final String tvShowId) {
        TvShowActivity_.intent(activityContext).tvShowId(tvShowId).start();
    }
}