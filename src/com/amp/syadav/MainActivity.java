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

public class MainActivity extends Activity 
{
	private Context ctx = null;
	private GridView Gv = null;
	private String[] HomeMenu = {"Biography", "Political Career","Samajwadi Party",
			"Events","In Media","Photo Gallary","Video Gallary","Social Media","Contact Us","Vidhan Sabha","Departments"};
	private String[] colorCodes = {"#d0021b", "#4a90e2","#f5a623",
			"#bd10e0", "#417505","#d0021b",
			"#4a90e2", "#f5a623","#bd10e0","#417505","#d0021b"};

	private Integer[] HomeMenuResouce = { R.drawable.ic_1,R.drawable.ic_9, R.drawable.ic_5,
			R.drawable.ic_4,R.drawable.ic_6, R.drawable.ic_2,
			R.drawable.ic_8,R.drawable.ic_7, R.drawable.ic_3,R.drawable.ic_6,R.drawable.ic_9};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ctx = this;
		headerSettings();

		Gv = (GridView) findViewById(R.id.gridHome);
		Gv.setAdapter(new MenuGridNewAdaptor(MainActivity.this,
				HomeMenuResouce, HomeMenu,colorCodes,R.layout.menu_grid_button));

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

					//					Intent webViewIntent = new Intent(getApplicationContext(),
					//							WebViewActivity.class);
					//					webViewIntent.putExtra("SOCIAL_URL", "https://dummy-class.herokuapp.com/events_list");
					//					String actTitle =  getResources().getString(R.string.title_activity_events);
					//					webViewIntent.putExtra("TITLE", actTitle);
					//					startActivity(webViewIntent);
					//					


					break;
				case 4:

					// inMedia
					//					Intent inMediaIntent = new Intent(getApplicationContext(),
					//							MediaActivity.class);
					//					startActivity(inMediaIntent);

					Intent webViewIntent1 = new Intent(getApplicationContext(),
							WebViewActivity.class);
					webViewIntent1.putExtra("SOCIAL_URL", "http://dummy-class.herokuapp.com/media");
					String actTitle1 =  getResources().getString(R.string.title_activity_media);
					webViewIntent1.putExtra("TITLE", actTitle1);
					startActivity(webViewIntent1);
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
				case 9:
					// Vidhan Sabha
										Intent vidhanIntent = new Intent(getApplicationContext(),
												VidhanSabhaActivity.class);
										startActivity(vidhanIntent);

				break;
				case 10:
					// Contact
					Intent departmentIntent = new Intent(getApplicationContext(),
							DepartmentActivity.class);
					startActivity(departmentIntent);

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
	public void gotoHome(View v){
		Intent i=new Intent(android.content.Intent.ACTION_SEND);
		i.setType("text/plain");
		i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Shivpal Singh Yadav");
		i.putExtra(android.content.Intent.EXTRA_TEXT, "To read more information Please visit http://shivpalsinghyadav.com/");
		startActivity(Intent.createChooser(i,"Share via"));
	}
}
