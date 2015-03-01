package com.amp.syadav;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class SocialMediaActivity extends Activity
{
	
	private Context ctx = null;
	private GridView Gv = null;
	private String[] HomeMenu = {"Facebook", "Google Plus","Twitter"};
	private String[] colorCodes = {"#d0021b", "#4a90e2","#f5a623"};
	
	private Integer[] HomeMenuResouce = { R.drawable.ic_launcher,R.drawable.ic_launcher, R.drawable.ic_launcher};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_social_media);
		headerSettings();
		

		Gv = (GridView) findViewById(R.id.gridHome);
		Gv.setAdapter(new MenuGridNewAdaptor(SocialMediaActivity.this,
				HomeMenuResouce, HomeMenu,colorCodes));
		
		Gv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					final int position, long arg3) {
				System.out.println("Position = " + position);

				Intent webViewIntent = new Intent(getApplicationContext(),
						WebViewActivity.class);
				
				switch (position)
				{
				case 0:
					// FaceBook
					webViewIntent.putExtra("SOCIAL_URL", "https://www.facebook.com/shivpalsinghyadav");
					break;
				case 1:
					// Google Plus
				
					webViewIntent.putExtra("SOCIAL_URL", "https://plus.google.com/+Shivpalsinghyadavorg#+Shivpalsinghyadavorg/posts");
					break;
				case 2:
					// Twitter
					webViewIntent.putExtra("SOCIAL_URL", "https://twitter.com/shivpalsinghyad");
					break;
	
				default:
					break;
				}
				startActivity(webViewIntent);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.social_media, menu);
		return true;
	}
	private void headerSettings() {
		findViewById(R.id.btnBackHeader).setVisibility(View.VISIBLE);
		findViewById(R.id.btnHomeHeader).setVisibility(View.GONE);	
		TextView headerTitle =(TextView)findViewById(R.id.txtHeading);
		headerTitle.setText(R.string.title_activity_social_media);
	}
	public void gotoBack(View v){
		finish();
	}
}
