package com.amp.syadav;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.hintdesk.ImageGridView_with_Flickr.adapters.MediumViewAdapter;
import com.hintdesk.ImageGridView_with_Flickr.implementations.CurrentAppData;

/**
 * Created by ServusKevin on 12/16/13.
 */
public class MediumViewActivity extends Activity {

	private ViewPager viewPager;

	CurrentAppData currentAppData;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medium_view);
		viewPager=(ViewPager)findViewById(R.id.pager);

		/*currentAppData=(CurrentAppData) getIntent().getParcelableExtra("currendata");*/
		currentAppData=MediumViewAdapter.currentAppData;
		if(currentAppData!=null)
		{
			MediumViewAdapter mediumViewAdapter = new MediumViewAdapter(MediumViewActivity.this,currentAppData);
			viewPager.setAdapter(mediumViewAdapter);
			viewPager.setCurrentItem(currentAppData.getCurrentPosition());
		}
	}
}