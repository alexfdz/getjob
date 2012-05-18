package com.a2devel.getjob.core.test;

import android.test.ActivityInstrumentationTestCase2;

import com.a2devel.getjob.core.PagerActivity;
import com.jayway.android.robotium.solo.Solo;

public class PagerActivityTest extends ActivityInstrumentationTestCase2<PagerActivity> {
	
	private final static String TAG = "PagerActivity";

	private Solo solo;

	public PagerActivityTest() {
		super(PagerActivity.class);
	}
	
	@Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation());
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}
