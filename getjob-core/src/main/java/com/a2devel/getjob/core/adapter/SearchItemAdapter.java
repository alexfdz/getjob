package com.a2devel.getjob.core.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.a2devel.getjob.core.R;
import com.a2devel.getjob.dao.Search;

public class SearchItemAdapter extends ArrayAdapter<Search> {

	private List<Search> items;
	private int layoutId;
	
	public SearchItemAdapter(Context context, int textViewResourceId, 
			List<Search> items) {
        super(context, textViewResourceId, items);
        this.items = items;
        this.layoutId = textViewResourceId;
	}
	
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = vi.inflate(this.layoutId, null);
            }
            Search search = items.get(position);
            if (search != null) {
                    TextView textView = (TextView) view.findViewById(R.id.searchText);
                    if (textView != null) {
                    	textView.setText("Name: "+ search.getId());                           
                    }
            }
            return view;
    }

}
