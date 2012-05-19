package com.a2devel.getjob.core.view;

import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.a2devel.getjob.core.PagerActivity;
import com.a2devel.getjob.core.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public abstract class ListViewWrapper{
	
	private PullToRefreshListView listView;
	private PagerActivity activity;
	
	public ListViewWrapper(PagerActivity activity){
		this.activity = activity;
	}
	
	public PullToRefreshListView getListView() {
		if(this.listView == null){
			this.listView = this.createListView();
		}
		return listView;
	}
	
	private PullToRefreshListView createListView(){
		PullToRefreshListView listView = null;
		
		ViewGroup viewGroup = (ViewGroup)activity.getLayoutInflater().inflate(R.layout.pull_to_refresh_list, null);
		listView = (PullToRefreshListView)viewGroup.getChildAt(0);
		
		ListView actualListView = listView.getRefreshableView();
		listView.setOnRefreshListener(getRefreshListener());
		actualListView.setAdapter(getAdapter());
		
		return listView;
	}
	
	protected PagerActivity getActivity() {
		return activity;
	}
	
	protected abstract ArrayAdapter<?> getAdapter();
	
	protected abstract OnRefreshListener2 getRefreshListener();
	
	public abstract String getTabText();
}
