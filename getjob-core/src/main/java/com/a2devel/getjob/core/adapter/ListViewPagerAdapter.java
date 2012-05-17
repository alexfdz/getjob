package com.a2devel.getjob.core.adapter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import android.app.Activity;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.a2devel.getjob.core.R;
import com.a2devel.getjob.core.task.GetOldDataTask;
import com.a2devel.getjob.core.task.ReloadDataTask;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;


public class ListViewPagerAdapter extends PagerAdapter {
	
	protected transient Activity activity;
	
	private Map<Integer,PullToRefreshListView> viewsMap;
	
	ViewGroup viewGroup;
	
	public ListViewPagerAdapter(Activity activity, ViewGroup viewGroup) {
		this.activity = activity;
		this.viewGroup = viewGroup;
		viewsMap = new HashMap<Integer,PullToRefreshListView>();
	}
	
	@Override
	public Object instantiateItem(View container, int position) {
		
		PullToRefreshListView listView = viewsMap.get(position);
		
		if(listView == null){
			listView = this.createListView();
			viewsMap.put(position, listView);
		}
		((ViewPager) container).addView(listView, 0);
		return listView;
	}
	
	
	private PullToRefreshListView createListView(){
		
		ViewGroup viewGroup = (ViewGroup)activity.getLayoutInflater().inflate(R.layout.pull_to_refresh_list, null);
		final PullToRefreshListView listView = (PullToRefreshListView)viewGroup.getChildAt(0);
		
		final LinkedList<String> listItems;
		final ArrayAdapter<String> arrayAdapter;
		
		ListView actualListView = listView.getRefreshableView();

		listItems = new LinkedList<String>();
		listItems.addAll(Arrays.asList("Abbaye de Belloc", "Abbaye du Mont des Cats","Abbaye de Belloc", "Abbaye du Mont des Cats","Abbaye de Belloc", "Abbaye du Mont des Cats","Abbaye de Belloc", "Abbaye du Mont des Cats","Abbaye de Belloc", "Abbaye du Mont des Cats"));

		arrayAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, listItems);
		
		// Set a listener to be invoked when the list should be refreshed.
				listView.setOnRefreshListener(new OnRefreshListener2() {

					@Override
					public void onPullDownToRefresh() {
						new ReloadDataTask(arrayAdapter, listItems, listView).execute();
					}

					@Override
					public void onPullUpToRefresh() {
						new GetOldDataTask(arrayAdapter, listItems, listView).execute();
					}
				});

		// You can also just use setListAdapter(mAdapter)
		actualListView.setAdapter(arrayAdapter);
		
		return listView;
	}
	
	@Override
	public void destroyItem(View container, int position, Object view) {
		((ViewPager) container).removeView((View) view);
	}
	
	
	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((View) object);
	}
	
	
	@Override
	public void finishUpdate(View container) {}
	
	@Override
	public void restoreState(Parcelable state, ClassLoader loader) {}
	
	@Override
	public Parcelable saveState() {
		return null;
	}
	
	@Override
	public void startUpdate(View container) {}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
}
