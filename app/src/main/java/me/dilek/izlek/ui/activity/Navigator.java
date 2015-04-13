package me.dilek.izlek.ui.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import org.androidannotations.annotations.EBean;

import me.dilek.izlek.R;
import me.dilek.izlek.domain.TvShow;
import me.dilek.izlek.ui.fragment.TvShowDraggableFragment;
import me.dilek.izlek.ui.fragment.TvShowFragment;

import static me.dilek.izlek.util.LogUtils.logi;

/**
 * Class to handle navigation between activities.
 *
 * @author Hakan Dilek on 10.04.2015.
 */
@EBean
public class Navigator {

    private TvShowFragment tvShowFragment;
    private TvShowDraggableFragment tvShowDraggableFragment;

    public void openTvShowDetails(TvShow tvShow, Context context) {

        if (canInteractWithFragments(context)) {
            showTvShowOnTvShowDraggableFragment(tvShow);
            showTvShowOnTvShowFragment(tvShow);
        } else {
            openTvShowActivity(context, tvShow.getTitle());
        }

    }


    private FragmentManager getFragmentManager(Context context) {
        logi("context:" + context);
        return ((FragmentActivity) context).getSupportFragmentManager();
    }

    private boolean canInteractWithFragments(Context context) {
        if (context == null) return false;
        FragmentManager fragmentManager = getFragmentManager(context);
        Fragment f_tv_show = fragmentManager.findFragmentById(R.id.f_tv_show);
        Fragment f_tv_show_draggable = fragmentManager.findFragmentById(R.id.f_tv_show_draggable);
        logi("f_tv_show:" + f_tv_show);
        logi("f_tv_show_draggable:" + f_tv_show_draggable);
        tvShowFragment = (TvShowFragment) f_tv_show;
        tvShowDraggableFragment = (TvShowDraggableFragment) f_tv_show_draggable;

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
    public void openTvShowActivity(Context context, final String tvShowId) {
        TvShowActivity_.intent(context).tvShowId(tvShowId).start();
    }
}