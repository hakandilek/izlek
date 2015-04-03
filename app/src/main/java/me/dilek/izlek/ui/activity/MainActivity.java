package me.dilek.izlek.ui.activity;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FragmentById;

import me.dilek.izlek.R;
import me.dilek.izlek.ui.fragment.TvShowDraggableFragment;
import me.dilek.izlek.ui.fragment.TvShowFragment;


@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {


    @FragmentById
    TvShowDraggableFragment f_tv_show_draggable;

    @FragmentById
    TvShowFragment f_tv_show;

    @AfterViews
    void afterViews() {
        if (f_tv_show != null && f_tv_show_draggable != null) {
            f_tv_show_draggable.disableSaveInstanceState();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
