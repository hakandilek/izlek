package me.dilek.izlek.ui.activity;

import android.support.v7.app.ActionBarActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.FragmentById;

import me.dilek.izlek.R;
import me.dilek.izlek.ui.fragment.TvShowFragment;

/**
 * Activity to show a single tv show
 * <p/>
 * Created by Hakan Dilek on 12.04.15.
 */
@EActivity(R.layout.activity_tv_show)
public class TvShowActivity extends ActionBarActivity {

    @FragmentById(R.id.f_tv_show)
    TvShowFragment tvShowFragment;

    @Extra("extra_tv_show_id")
    String tvShowId;

    @AfterViews
    void initializeFragment() {
        TvShowFragment tvShowFragment =
                (TvShowFragment) getSupportFragmentManager().findFragmentById(R.id.f_tv_show);
        tvShowFragment.showTvShow(tvShowId);
    }

}
