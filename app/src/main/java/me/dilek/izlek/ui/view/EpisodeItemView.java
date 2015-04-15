package me.dilek.izlek.ui.view;

import android.content.Context;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import me.dilek.izlek.R;
import me.dilek.cezmi.domain.Episode;

/**
 * Renderer for an episode
 * <p/>
 * Created by Hakan Dilek on 12.04.15.
 */
@EViewGroup(R.layout.row_episode)
public class EpisodeItemView extends AbstractItemView<Episode> {

    @ViewById(R.id.tv_episode_number)
    TextView tv_episode_number;

    @ViewById(R.id.tv_episode_title)
    TextView tv_episode_title;

    @ViewById(R.id.tv_episode_publish_date)
    TextView tv_episode_publish_date;

    private int position;

    public EpisodeItemView(Context context) {
        super(context);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void bind(Episode episode) {
        renderEpisodeNumber();
        renderEpisodeTitle(episode);
        renderEpisodePublishDate(episode);
    }

    private void renderEpisodeNumber() {
        tv_episode_number.setText(String.format("%02d", position + 1));
    }

    private void renderEpisodeTitle(Episode episode) {
        String title = episode.getTitle();
        tv_episode_title.setText(title);
    }

    private void renderEpisodePublishDate(Episode episode) {
        String publishDate = episode.getPublishDate();
        tv_episode_publish_date.setText(publishDate);
    }

}
