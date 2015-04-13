package me.dilek.izlek.ui.activity;

import android.support.v7.app.ActionBarActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FragmentById;

import me.dilek.izlek.R;
import me.dilek.izlek.ui.fragment.TvShowDraggableFragment;
import me.dilek.izlek.ui.fragment.TvShowFragment;


@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {

    @FragmentById(R.id.f_tv_show_draggable)
    TvShowDraggableFragment f_tv_show_draggable;

    @FragmentById(R.id.f_tv_show)
    TvShowFragment f_tv_show;

    @AfterViews
    void afterViews() {
        if (f_tv_show != null && f_tv_show_draggable != null) {
            f_tv_show_draggable.disableSaveInstanceState();
        }
    }

}
