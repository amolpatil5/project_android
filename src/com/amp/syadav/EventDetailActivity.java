package com.amp.syadav;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDetailActivity extends Activity {
  TextView detailsTxt;
  
  String detailStr;
  String imageName;
  ImageView eventDetailImageView;
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_detail);
		
		headerSettings();
		detailsTxt = (TextView)findViewById(R.id.eventDetail);
		
		Intent intent = getIntent();
		detailStr = intent.getStringExtra("EVENT_DETAIL");
		imageName = intent.getStringExtra("IMAGE_NAME");
		
		eventDetailImageView = (ImageView)findViewById(R.id.eventDetailImageView);
		
		detailsTxt.setText (detailStr);
		
	}
	
	private void headerSettings() {
		findViewById(R.id.btnBackHeader).setVisibility(View.VISIBLE);
		findViewById(R.id.btnHomeHeader).setVisibility(View.GONE);	
		TextView headerTitle =(TextView)findViewById(R.id.txtHeading);
		headerTitle.setText(R.string.title_activity_events);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event_detail, menu);
		return true;
	}
	public void gotoBack(View v){
		finish();
	}
}
