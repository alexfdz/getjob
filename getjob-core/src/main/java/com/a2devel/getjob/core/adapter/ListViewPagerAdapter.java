package com.a2devel.getjob.core.adapter;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.a2devel.getjob.core.PagerActivity;
import com.a2devel.getjob.core.R;
import com.a2devel.getjob.core.view.AppliedResultsView;
import com.a2devel.getjob.core.view.FavoriteResultsView;
import com.a2devel.getjob.core.view.ListViewWrapper;
import com.a2devel.getjob.core.view.ResultsView;
import com.astuetz.viewpager.extensions.TabsAdapter;


public class ListViewPagerAdapter extends PagerAdapter implements TabsAdapter {
	
	protected transient PagerActivity activity;
	
	private List<ListViewWrapper> viewsList;
	
	public ListViewPagerAdapter(PagerActivity activity) {
		this.activity = activity;
		this.createViews();
	}
	
	private void createViews(){
		viewsList = new ArrayList<ListViewWrapper>();
		viewsList.add(new ResultsView(activity));
		viewsList.add(new FavoriteResultsView(activity));
		viewsList.add(new AppliedResultsView(activity));
	}
	
	@Override
	public Object instantiateItem(View container, int position) {
		ListViewWrapper wrapper = viewsList.get(position);
		View view = null;
		if(wrapper != null){
			view = wrapper.getListView();
		}
		((ViewPager) container).addView(view, position);
		return view;
	}
	
	@Override
	public View getView(int position) {
		LayoutInflater inflater = activity.getLayoutInflater();
		Button tab = (Button) inflater.inflate(R.layout.tab_scrolling, null);
		ListViewWrapper wrapper = viewsList.get(position);
		if(wrapper != null){
			tab.setText(wrapper.getTabText());
		}
		return tab;
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
		return viewsList.size();
	}
}
