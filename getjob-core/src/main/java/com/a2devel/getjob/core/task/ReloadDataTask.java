package com.a2devel.getjob.core.task;

import java.util.LinkedList;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class ReloadDataTask extends AsyncTask<Void, Void, String[]> {

	private ArrayAdapter<String> arrayAdapter;
	private LinkedList<String> items;
	private PullToRefreshListView listView;
	
	
	public ReloadDataTask(ArrayAdapter<String> arrayAdapter, LinkedList<String> items, PullToRefreshListView listView){
		this.arrayAdapter = arrayAdapter;
		this.items = items;
		this.listView = listView;
	}
	
	@Override
	protected String[] doInBackground(Void... params) {
		// Simulates a background job.
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}
		return new String[]{"Abbaye de Belloc1", "Abbaye du Mont des Cats2"};
	}

	@Override
	protected void onPostExecute(String[] result) {
		items.addFirst("Added after top refresh...");
		arrayAdapter.notifyDataSetChanged();

		// Call onRefreshComplete when the list has been refreshed.
		listView.onRefreshComplete();

		super.onPostExecute(result);
	}
}
