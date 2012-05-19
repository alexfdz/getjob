package com.a2devel.getjob.core.view;

import java.util.List;

import com.a2devel.getjob.core.PagerActivity;
import com.a2devel.getjob.core.R;
import com.a2devel.getjob.dao.Result;
import com.a2devel.getjob.dao.ResultDao.Properties;

public class AppliedResultsView extends ResultsView{

	public AppliedResultsView(PagerActivity activity) {
		super(activity);
	}
	
	@Override
	public String getTabText() {
		return getActivity().getString(R.string.tab_applied);
	}
	
	protected List<Result> getItems(){
		if(items == null){
			items = getResultDao().queryBuilder().where(Properties.Applied.eq(0)).list();
		}
		return items;
	}

}
