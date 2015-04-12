package me.dilek.izlek.ui.renderer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.ViewById;

import me.dilek.izlek.R;
import me.dilek.izlek.domain.Episode;

/**
 * Renderer for an episode
 * <p/>
 * Created by Hakan Dilek on 12.04.15.
 */
@EBean
public class EpisodeRenderer extends AbstractRenderer<Episode> {

    @SystemService
    LayoutInflater layoutInflater;

    @ViewById(R.id.tv_episode_number)
    TextView tv_episode_number;

    @ViewById(R.id.tv_episode_title)
    TextView tv_episode_title;

    @ViewById(R.id.tv_episode_publish_date)
    TextView tv_episode_publish_date;

    private int position;

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    protected View inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.row_episode, viewGroup, false);
    }

    @Override
    protected LayoutInflater layoutInflater() {
        return layoutInflater;
    }

    @Override
    protected void update(RendererValue value) {
        Episode episode = value.content;
        renderEpisodeNumber();
        renderEpisodeTitle(episode);
        renderEpisodePublishDate(episode);
    }

    private void renderEpisodeNumber() {
        tv_episode_number.setText(String.format("%02d", position + 1));
    }

    private void renderEpisodeTitle(Episode episode) {
        tv_episode_title.setText(episode.getTitle());
    }

    private void renderEpisodePublishDate(Episode episode) {
        tv_episode_publish_date.setText(episode.getPublishDate());
    }
}
