package com.amp.syadav;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity 
{
	private Context ctx = null;
	private GridView Gv = null;
	private String[] HomeMenu = {"Biography", "Political Career","Samajwadi Party",
			"Events","In Media","Photo Gallary","Video Gallary","Social Media","Contact Us"};
	private String[] colorCodes = {"#d0021b", "#4a90e2","#f5a623",
									"#bd10e0", "#417505","#d0021b",
									"#4a90e2", "#f5a623","#bd10e0"};
	
	private Integer[] HomeMenuResouce = { R.drawable.ic_launcher,R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher,R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher,R.drawable.ic_launcher, R.drawable.ic_launcher};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ctx = this;
		headerSettings();
//		ActionBar actionBar = getActionBar();
//	actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.navbar));
//		actionBar.setTitle("Shivpal Singh Yadav");
		//actionBar.setLogo(R.drawable.partylogo);
		
		Gv = (GridView) findViewById(R.id.gridHome);
		Gv.setAdapter(new MenuGridNewAdaptor(MainActivity.this,
				HomeMenuResouce, HomeMenu,colorCodes));
		
		Gv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					final int position, long arg3) {
				System.out.println("Position = " + position);

				switch (position) {
				case 0:
					// BioGraphy
					Intent biographyIntent = new Intent(getApplicationContext(),
							BiographyActivity.class);
					startActivity(biographyIntent);

					break;
				case 1:
					// Political Career
					Intent politicalCareerIntent = new Intent(getApplicationContext(),
							PoliticalCareerActivity.class);
					startActivity(politicalCareerIntent);

					break;
				case 2:
					// Samajwadi Party
					Intent samajwadiPartyIntent = new Intent(
							getApplicationContext(),
							SamajwadiPartyActivity.class);
					//sportsListIntent.putExtra("LAUNH_FROM", "ScheduleTile");
					startActivity(samajwadiPartyIntent);
					break;
				case 3:
					// Events
					Intent eventsIntent = new Intent(getApplicationContext(),
							EventsActivity.class);
					startActivity(eventsIntent);

					break;
				case 4:
					
					// inMedia
					Intent inMediaIntent = new Intent(getApplicationContext(),
							MediaActivity.class);
					startActivity(inMediaIntent);
					break;
				case 5:
					// PhotoGallary
					Intent photoGallaryIntent = new Intent(getApplicationContext(),
							PhotoGallaryActivity.class);
					startActivity(photoGallaryIntent);

					break;
				case 6:
					// Video
					Intent videoGallaryIntent = new Intent(getApplicationContext(),
							VideoGallaryActivity.class);
					startActivity(videoGallaryIntent);

					break;
				case 7:
					// Contact
					Intent socialMediaIntent = new Intent(getApplicationContext(),
							SocialMediaActivity.class);
					startActivity(socialMediaIntent);

					break;

				case 8:
					// Contact
					Intent contactIntent = new Intent(getApplicationContext(),
							ContactActivity.class);
					startActivity(contactIntent);

					break;

				default:
					break;
				}
			}
		});
		
	}
	private void headerSettings() {
		findViewById(R.id.btnBackHeader).setVisibility(View.GONE);
		findViewById(R.id.btnHomeHeader).setVisibility(View.VISIBLE);	
		TextView headerTitle =(TextView)findViewById(R.id.txtHeading);
		headerTitle.setText(R.string.app_name);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
