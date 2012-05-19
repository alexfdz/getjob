package com.a2devel.getjob.core;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.a2devel.getjob.core.adapter.ListViewPagerAdapter;
import com.a2devel.getjob.dao.DaoMaster;
import com.a2devel.getjob.dao.DaoMaster.DevOpenHelper;
import com.a2devel.getjob.dao.DaoSession;
import com.a2devel.getjob.dao.ResultDao;
import com.a2devel.getjob.dao.SearchDao;
import com.astuetz.viewpager.extensions.ScrollingTabsView;

public class PagerActivity extends Activity {
	
	private ViewPager viewPager;
	private ScrollingTabsView scrollingTabs;
	
	private ListViewPagerAdapter adapter;
	
    private ResultDao resultDao;
    private SearchDao searchDao;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.initDataAccess();
		
		setContentView(R.layout.activity_scrolling_tabs);
		adapter = new ListViewPagerAdapter(this);
		
		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(1);
		viewPager.setPageMargin(1);
		
		scrollingTabs = (ScrollingTabsView) findViewById(R.id.scrolling_tabs);
		scrollingTabs.setAdapter(adapter);
		scrollingTabs.setViewPager(viewPager);
	}
	
	private void initDataAccess() {
		DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "greendao", null);
		SQLiteDatabase database = null;
		try {
			database = helper.getWritableDatabase();
		} catch (Exception e) {
			System.out.println(e.getMessage());//TODO
		}
		DaoMaster daoMaster = new DaoMaster(database);
		DaoSession daoSession = daoMaster.newSession();
		resultDao = daoSession.getResultDao();
	    searchDao = daoSession.getSearchDao();
	}

	public ResultDao getResultDao() {
		return resultDao;
	}

	public SearchDao getSearchDao() {
		return searchDao;
	}
}
