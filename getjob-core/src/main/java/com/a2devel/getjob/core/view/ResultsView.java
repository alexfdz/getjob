package com.a2devel.getjob.core.view;

import java.util.List;

import android.widget.ArrayAdapter;

import com.a2devel.getjob.core.PagerActivity;
import com.a2devel.getjob.core.R;
import com.a2devel.getjob.core.adapter.ResultItemAdapter;
import com.a2devel.getjob.dao.Result;
import com.a2devel.getjob.dao.ResultDao;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;

public class ResultsView extends ListViewWrapper{

	protected List<Result> items;
	private ResultDao resultDao;
	
	public ResultsView(PagerActivity activity) {
		super(activity);
		this.resultDao = activity.getResultDao();
	}

	@Override
	protected ArrayAdapter<?> getAdapter() {
		return new ResultItemAdapter(getActivity(), R.layout.result_item, getItems());
	}

	@Override
	protected OnRefreshListener2 getRefreshListener() {
		return null;
	}

	@Override
	public String getTabText() {
		return getActivity().getString(R.string.tab_results);
	}
	
	protected List<Result> getItems(){
		if(items == null){
			items = getActivity().getResultDao().loadAll();
		}
		return items;
	}

	public ResultDao getResultDao() {
		return resultDao;
	}

}
