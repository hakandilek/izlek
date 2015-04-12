package me.dilek.izlek.ui.renderer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pedrogomez.renderers.Renderer;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.ViewById;

import me.dilek.izlek.R;
import me.dilek.izlek.domain.TvShow;
import me.dilek.izlek.ui.presenter.TvShowCatalogPresenter;

/**
 * Renderer for a TV show
 * Created by Hakan Dilek on 11.04.15.
 */
@EBean
public class TvShowRenderer extends Renderer<TvShow> {

    @RootContext
    Context context;

    @Bean
    TvShowCatalogPresenter tvShowCatalogPresenter;

    @ViewById(R.id.iv_thumbnail)
    ImageView thumbnailImageView;

    @ViewById(R.id.tv_title)
    TextView titleTextView;

    @ViewById(R.id.tv_seasons_counter)
    TextView seasonsCounterTextView;

    @Override
    protected void setUpView(View rootView) {

    }

    @Override
    protected void hookListeners(View rootView) {

    }

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.row_tv_show, parent, false);
    }

    @Override
    public void render() {
        TvShow tvShow = getContent();
        renderThumbnail(tvShow);
        renderTitle(tvShow);
        renderSeasonCounter(tvShow);
    }


    @Click(R.id.iv_thumbnail)
    void onThumbnailClicked() {
        tvShowCatalogPresenter.onTvShowThumbnailClicked(getContent());
    }

    @Click(R.id.v_row_container)
    void onBackgroundClicked() {
        tvShowCatalogPresenter.onTvShowClicked(getContent());
    }

    private TvShow renderThumbnail(TvShow tvShow) {
        Picasso.with(context).load(tvShow.getPoster()).into(thumbnailImageView);
        return tvShow;
    }

    private void renderTitle(TvShow tvShow) {
        titleTextView.setText(tvShow.getTitle().toUpperCase());
    }

    private void renderSeasonCounter(TvShow tvShow) {
        String seasons = context.getString(R.string.seasons_counter, tvShow.getNumberOfSeasons());
        seasonsCounterTextView.setText(seasons);
    }
}
