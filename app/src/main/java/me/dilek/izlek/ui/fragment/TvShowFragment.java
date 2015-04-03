package me.dilek.izlek.ui.fragment;

import android.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import me.dilek.izlek.R;

@EFragment(R.layout.fragment_tv_show)
public class TvShowFragment extends Fragment {


	/*
      @Inject TvShowViewModel tvShowViewModel;
	  @Inject ChapterViewModelRendererAdapterFactory chapterRendererAdapterFactory;

	  private ChapterViewModelRendererAdapter adapter;
	  private ChapterViewModelCollection chapterAdapteeCollection = new ChapterViewModelCollection();
	 */

    @ViewById
    ImageView iv_fan_art;
    @ViewById
    ListView lv_chapters;
    @ViewById
    ProgressBar pb_loading;
    @ViewById
    View v_empty_case;

    private TextView header_tv_show_chapters;

}
