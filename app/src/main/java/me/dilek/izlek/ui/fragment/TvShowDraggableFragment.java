package me.dilek.izlek.ui.fragment;

import android.app.Fragment;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.github.pedrovgs.DraggableView;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import me.dilek.izlek.R;

@EFragment(R.layout.fragment_draggable_tv_show)
public class TvShowDraggableFragment extends Fragment {

    private static final String EXTRA_TV_SHOW = "extra_tv_show";

	/*
    TvShowPresenter tvShowPresenter;

	ChapterRendererAdapterFactory chapterRendererAdapterFactory;

	private ChapterRendererAdapter adapter;
	private ChapterAdapteeCollection chapterAdapteeCollection = new ChapterAdapteeCollection();
	 */

    private boolean useSaveInstanceState = true;

    @ViewById
    DraggableView draggable_view;
    @ViewById
    ImageView iv_fan_art;
    @ViewById
    ListView lv_chapters;
    @ViewById
    ProgressBar pb_loading;

    public void disableSaveInstanceState() {
        useSaveInstanceState = false;
    }

}
