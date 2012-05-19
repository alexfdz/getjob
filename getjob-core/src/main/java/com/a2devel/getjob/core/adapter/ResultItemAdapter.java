package com.a2devel.getjob.core.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.a2devel.getjob.core.R;
import com.a2devel.getjob.dao.Result;

public class ResultItemAdapter extends ArrayAdapter<Result> {

	private List<Result> items;
	private int layoutId;
	
	public ResultItemAdapter(Context context, int textViewResourceId, 
			List<Result> items) {
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
            Result result = items.get(position);
            if (result != null) {
                    TextView tt = (TextView) view.findViewById(R.id.toptext);
                    TextView bt = (TextView) view.findViewById(R.id.bottomtext);
                    if (tt != null) {
                          tt.setText("Name: "+ result.getText());                            }
                    if(bt != null){
                          bt.setText("Status: "+ result.getUrl());
                    }
            }
            return view;
    }

}
