package com.a2devel.getjob.core;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.a2devel.getjob.core.adapter.ListViewPagerAdapter;
import com.a2devel.getjob.core.adapter.ScrollingTabsAdapter;
import com.astuetz.viewpager.extensions.ScrollingTabsView;
import com.astuetz.viewpager.extensions.TabsAdapter;

public class PagerActivity extends Activity {
	
	private ViewPager mPager;
	private ScrollingTabsView mScrollingTabs;
	
	private PagerAdapter mPagerAdapter;
	private TabsAdapter mScrollingTabsAdapter;
	
	public static final String EXTRA_EXAMPLE_TYPE = "EXTRA_EXAMPLE_TYPE";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_scrolling_tabs);

		mPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new ListViewPagerAdapter(this, mPager);
		mPager.setAdapter(mPagerAdapter);
		mPager.setCurrentItem(1);
		mPager.setPageMargin(1);
		
		mScrollingTabs = (ScrollingTabsView) findViewById(R.id.scrolling_tabs);
		mScrollingTabsAdapter = new ScrollingTabsAdapter(this);
		mScrollingTabs.setAdapter(mScrollingTabsAdapter);
		mScrollingTabs.setViewPager(mPager);
		
	}
	
	
}
