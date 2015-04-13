package me.dilek.izlek.ui.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import me.dilek.izlek.R;
import me.dilek.izlek.domain.TvShow;

/**
 * Renderer for a TV show
 * Created by Hakan Dilek on 11.04.15.
 */
@EViewGroup(R.layout.row_tv_show)
public class TvShowItemView extends AbstractItemView<TvShow> {

    @ViewById(R.id.iv_thumbnail)
    ImageView thumbnailImageView;

    @ViewById(R.id.tv_title)
    TextView titleTextView;

    @ViewById(R.id.tv_seasons_counter)
    TextView seasonsCounterTextView;

    public TvShowItemView(Context context) {
        super(context);
    }

    public void bind(TvShow tvShow) {
        renderThumbnail(tvShow);
        renderTitle(tvShow);
        renderSeasonCounter(tvShow);
    }

    private TvShow renderThumbnail(TvShow tvShow) {
        Context context = getContext();
        String poster = tvShow.getPoster();
        Picasso.with(context).load(poster).into(thumbnailImageView);
        return tvShow;
    }

    private void renderTitle(TvShow tvShow) {
        String title = tvShow.getTitle();
        title = title.toUpperCase();
        titleTextView.setText(title);
    }

    private void renderSeasonCounter(TvShow tvShow) {
        String seasons = getContext().getString(R.string.seasons_counter, tvShow.getNumberOfSeasons());
        seasonsCounterTextView.setText(seasons);
    }

}
