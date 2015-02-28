/*******************************************************************************
 * Author: Amol Bharat Patil
 */
package com.amp.syadav;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuGridNewAdaptor extends BaseAdapter {
	private Integer[] menuarr = null;
	private Context ctx = null;
	private String[] ContentDesc = null;

	public MenuGridNewAdaptor(Context c, Integer[] homeGrid,
			String[] ContentDescription) {
		menuarr = homeGrid;
		ContentDesc = ContentDescription;
		ctx = c;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView i;
		TextView txt;
		if (convertView == null) {
			convertView = LayoutInflater.from(ctx).inflate(
					R.layout.menu_grid_button, parent, false);
			i = (ImageView) convertView
					.findViewById(R.id.imgSelectorBackground);
			String contentDes = ContentDesc[position].replace("\n", "");
//			i.setContentDescription(contentDes + " Button");
			i.setImageResource(menuarr[position]);
			txt = (TextView) convertView.findViewById(R.id.txtSelectorText);
			txt.setText(ContentDesc[position]);

		} else {
			convertView = (FrameLayout) convertView;
		}

		return convertView;
	}

	public final int getCount() {
		return menuarr.length;
	}

	public final Object getItem(int position) {
		return menuarr[position];
	}

	public final long getItemId(int position) {
		return position;
	}
}
