package com.amp.helper;

import java.util.ArrayList;

import com.amp.syadav.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class EventCellAdaptor extends ArrayAdapter<EventsData>
{

	final Context context;
	int layoutResourceId;
	final ArrayList<EventsData> data;

	public EventCellAdaptor(Context context, int textViewResourceId,
			ArrayList<EventsData> data) {
		super(context, textViewResourceId, data);
		this.layoutResourceId = textViewResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;

		if (row == null) 
		{
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);
			final EventsDataHolder holder = new EventsDataHolder();
			holder.eventDesc = (TextView) row.findViewById(R.id.eventDesc);
		   holder.eventTime = (TextView) row.findViewById(R.id.eventTime);

			row.setTag(holder);
		} else {
			row = convertView;
			((EventsDataHolder) row.getTag()).eventTime.setTag(data
					.get(position));
			((EventsDataHolder) row.getTag()).eventDesc.setTag(data
					.get(position));

		}

		EventsDataHolder holder = (EventsDataHolder) row.getTag();
		EventsData weather = data.get(position);
		holder.eventDesc.setText(weather.descStr);
		holder.eventTime.setText(weather.timeStr);

		return row;
	}

	static class EventsDataHolder 
	{
		TextView eventDesc;
		TextView eventTime;
	}

}
