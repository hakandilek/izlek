package me.dilek.izlek.ui.fragment;

import android.view.View;

import com.github.pedrovgs.DraggableListener;
import com.github.pedrovgs.DraggableView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import me.dilek.izlek.R;
import me.dilek.izlek.ui.presenter.TvShowPresenter;

@EFragment(R.layout.fragment_draggable_tv_show)
public class TvShowDraggableFragment extends TvShowFragment implements TvShowPresenter.View {

    private static final String EXTRA_TV_SHOW = "extra_tv_show";

    @ViewById
    DraggableView draggable_view;

    @AfterViews
    @Background
    public void initialize() {
        tvShowPresenter.setView(this);
        initializeListView();
        initializeDraggableView();
    }

    void initializeDraggableView() {
        draggable_view.post(new Runnable() {
            @Override
            public void run() {
                draggable_view.closeToRight();
            }
        });
        draggable_view.setDraggableListener(new DraggableListener() {
            @Override
            public void onMaximized() {
                //Empty
            }

            @Override
            public void onMinimized() {
                //Empty
            }

            @Override
            public void onClosedToLeft() {
                tvShowPresenter.tvShowClosed();
            }

            @Override
            public void onClosedToRight() {
                tvShowPresenter.tvShowClosed();
            }
        });
    }

    @Override
    public void showTvShow() {
        draggable_view.setVisibility(View.VISIBLE);
        draggable_view.maximize();
    }
}
