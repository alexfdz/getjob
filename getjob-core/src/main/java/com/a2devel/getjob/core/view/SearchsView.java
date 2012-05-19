package com.a2devel.getjob.core.view;

import java.util.List;

import android.widget.ArrayAdapter;

import com.a2devel.getjob.core.PagerActivity;
import com.a2devel.getjob.core.R;
import com.a2devel.getjob.core.adapter.SearchItemAdapter;
import com.a2devel.getjob.dao.Search;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;

public class SearchsView extends ListViewWrapper{

	protected List<Search> items;
	
	public SearchsView(PagerActivity activity) {
		super(activity);
	}

	@Override
	protected ArrayAdapter<?> getAdapter() {
		return new SearchItemAdapter(getActivity(), R.layout.search_item, getItems());
	}

	@Override
	protected OnRefreshListener2 getRefreshListener() {
		return null;
	}

	@Override
	public String getTabText() {
		return getActivity().getString(R.string.tab_searchs);
	}
	
	protected List<Search> getItems(){
		if(items == null){
			items = getActivity().getSearchDao().loadAll();
		}
		return items;
	}

}
