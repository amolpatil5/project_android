package com.amp.syadav;



import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import com.amp.helper.Constants;
import com.amp.helper.Utility;
import com.twostars.syadav.R;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends Activity 
{
	private Context ctx = null;
	private GridView Gv = null;
	 Dialog dialog;
	private String[] HomeMenu = {"Biography", "Political Career","Samajwadi Party",
			"Events","In Media","Video Gallary","Social Media","Vidhan Sabha","Departments", "Contact Us"};

    private String[] colorCodes = {"#d0021b", "#4a90e2","#f5a623",
			"#bd10e0", "#417505","#d0021b",
			"#4a90e2", "#f5a623","#bd10e0","#d0021b"};

	private Integer[] HomeMenuResouce = {
            R.drawable.ic_1,
		    R.drawable.ic_9,
            R.drawable.ic_5,
			R.drawable.ic_4,
            R.drawable.ic_8,
			R.drawable.ic_6,
            R.drawable.ic_7,
            R.drawable.ic_10,
            R.drawable.ic_11,
            R.drawable.ic_3,
           
            };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ctx = this;
		headerSettings();
		
		if(Utility.isNetworkStatusAvialable(getApplicationContext()))
		{
		  new getUpgradeTask().execute("updates");
		} 

		Gv = (GridView) findViewById(R.id.gridHome);
		Gv.setAdapter(new MenuGridNewAdaptor(MainActivity.this,
				HomeMenuResouce, HomeMenu,colorCodes,R.layout.menu_grid_button));

		Gv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					final int position, long arg3) {
				
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
					Intent webViewIntent1 = new Intent(getApplicationContext(),
							WebViewActivity.class);
					webViewIntent1.putExtra("SOCIAL_URL", "http://dummy-class.herokuapp.com/media");
					String actTitle1 =  getResources().getString(R.string.title_activity_media);
					webViewIntent1.putExtra("TITLE", actTitle1);
					startActivity(webViewIntent1);
					break;
				case 5:
					// Video
					Intent videoGallaryIntent = new Intent(getApplicationContext(),
							VideoGallaryActivity.class);
					startActivity(videoGallaryIntent);

					break;
				case 6:
					// Contact
					Intent socialMediaIntent = new Intent(getApplicationContext(),
							SocialMediaActivity.class);
					startActivity(socialMediaIntent);

					break;

				case 9:
					// Contact
					Intent contactIntent = new Intent(getApplicationContext(),
							ContactActivity.class);
					startActivity(contactIntent);

					break;
				case 7:
					// Vidhan Sabha
										Intent vidhanIntent = new Intent(getApplicationContext(),
												VidhanSabhaActivity.class);
										startActivity(vidhanIntent);

				break;
				case 8:
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
    public void upgradeBtnClicked(View v)
    {  
    	Intent intent = new Intent(Intent.ACTION_VIEW);
    	intent.setData(Uri.parse("market://details?id="+getApplicationContext().getPackageName()));
    	startActivity(intent);
    	dialog.dismiss();
    }  
    public void cancelBtnClicked(View v)
    {  
    dialog.dismiss();
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
	
	private class getUpgradeTask extends AsyncTask<String, Void, String> {
		
  @Override
  protected String doInBackground(String... params)
  {
  	HttpClient httpclient = new DefaultHttpClient();
      HttpGet httppost;
	try {
		httppost = new HttpGet(Constants.UPGRADE_URL + "?current_version="+Utility.getAppVersion(getApplicationContext()));
	
          // Execute HTTP Post Request
          HttpResponse response = httpclient.execute(httppost);
          String content = EntityUtils.toString(response.getEntity());
          System.out.println("Content = "+content);
          return content;
      } catch (ClientProtocolException e) {
          // TODO Auto-generated catch block
      } catch (IOException e) {
          // TODO Auto-generated catch block
      } catch (NameNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return null;
  }

  @Override
  protected void onPostExecute(String result) 
  {
  	// dialog.dismiss();
	 
			 JSONObject objJSONObject;
			try {
				objJSONObject = new JSONObject(result);
				 System.out.println("objJSONObject = "+objJSONObject.toString());
				
				 boolean isUpgradeRequired = (Boolean) objJSONObject.get("flag");
				 if(isUpgradeRequired)
				 {
					 
					dialog = new  Dialog(MainActivity.this);
					 
		                //tell the Dialog to use the dialog.xml as it's layout description
		                dialog.setContentView(R.layout.custom_dialog);
		                dialog.setTitle("Upgrade Message");
		                
		              
		                TextView txt = (TextView) dialog.findViewById(R.id.txt);
		 
		                txt.setText("A New Version of Application is available.To download click on Upgrade. Thank you.");
	 
		                Button upgradeBtn = (Button) dialog.findViewById(R.id.upgradeButton);
//		 
		                upgradeBtn.setOnClickListener(new OnClickListener() {
		                    @Override
		                    public void onClick(View v) {
		                        upgradeBtnClicked(v);
		                    }
		                });
		                Button cancelBtn = (Button) dialog.findViewById(R.id.cancelButton);
//		       		 
		                cancelBtn.setOnClickListener(new OnClickListener() {
		       		                    @Override
		       		                    public void onClick(View v) {
		       		                        dialog.cancel();
		       		                    }
		       		                });
//		 
		                dialog.show();
		            }
					 
					 
//						AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//			            builder.setCancelable(true);
//			            builder.setIcon(R.drawable.ic_launcher);
//			            builder.setTitle("Upgrade Message");
//			          
//			            builder.setMessage("A New Version of Application is available.To download click on Upgrade. Thank you.");
//			            builder.setInverseBackgroundForced(true);
//			            builder.setPositiveButton("Upgrade", new DialogInterface.OnClickListener() {
//			                public void onClick(DialogInterface dialog, int id)
//			                {
//			                	goToUpgrade();
//			                }});
//			            builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
//			                public void onClick(DialogInterface dialog, int id) {
//			                    dialog.cancel();
//			                }
//			            });
//			            AlertDialog alert = builder.create();		            
//			            alert.show();
//			            
//			            Button negativeBtn = alert.getButton(DialogInterface.BUTTON_NEGATIVE);  
//			            negativeBtn.setBackgroundColor(Color.BLUE);
//			            Button positiveBtn = alert.getButton(DialogInterface.BUTTON_NEGATIVE);  
//			            negativeBtn.setBackgroundColor(Color.BLUE);
//				 }
			} catch (JSONException e) 
			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
//			 
			
  }


  @Override
  protected void onPreExecute() {
//      dialog = new ProgressDialog(MainActivity.this);
//      dialog.setMessage("Please Wait..");
//      dialog.setIndeterminate(true);
//      dialog.setCancelable(false);
//      dialog.show();
  }

  @Override
  protected void onProgressUpdate(Void... values) {
  }
}

}
