package com.amp.syadav;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.amp.helper.*;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class EventsActivity extends Activity 
{
	ArrayList<EventsData> values;
	EventCellAdaptor adap;
	ListView eventsListView ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		values = new ArrayList<EventsData>();
		
		
		EventsData event1 = new EventsData("This is first event", "28 feb 2015");
		EventsData event2 = new EventsData("This is Second event for Application", "2 march 2015");
		values.add(event1);
		values.add(event2);
		
		eventsListView = (ListView) findViewById(R.id.eventsListView);
		adap = new EventCellAdaptor(this,R.layout.customcellview, values);
		eventsListView.setAdapter(adap);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.events, menu);
		return true;
	}
	public void refreshEventsUI(String results) throws JSONException 
	{
	System.out.println("IMGUpdatesActivity.refreshUpdatesUI()");	
	ArrayList<EventsData> respSchData = getEventsDataList(results);
	this.values.addAll(respSchData);
	adap.notifyDataSetChanged();
	}
	
	private class getEventsDataTask extends AsyncTask<String, Void, String> {
		  ProgressDialog dialog;
    @Override
    protected String doInBackground(String... params)
    {
    	HttpClient httpclient = new DefaultHttpClient();
        HttpGet httppost = new HttpGet(Constants.GET_EVENTS_DATA_URL);
        try 
        {
            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);
            System.out.println("Response :"+response.toString());
            String content = EntityUtils.toString(response.getEntity());
            System.out.println("Content :"+content);
            return content;
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) 
    {
    	 dialog.dismiss();
   
				try {
					refreshEventsUI(result);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
    	
    }

  
    @Override
    protected void onPreExecute() {
        dialog = new ProgressDialog(EventsActivity.this);
        dialog.setMessage("Please Wait..");
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }
}
	 //Following method will parse  Schedule Data
	 ArrayList<EventsData> getEventsDataList(String result) throws JSONException
	 {
		 ArrayList<EventsData> toReturnList = new ArrayList<EventsData>();
		 JSONObject objJSONObject  =  new JSONObject(result);
		 
		 System.out.println("objJSONObject = "+objJSONObject.toString());
		 JSONArray jsonObjectArr =  objJSONObject.getJSONArray("Events");
	       
		for(int i = 0, count = jsonObjectArr.length(); i< count; i++)
			{
			    try 
			    {
			    	EventsData tempSchData =new EventsData();
			    	JSONObject jsonChildNode = jsonObjectArr.getJSONObject(i);
                 
                 /******* Fetch node values **********/
                
			    	tempSchData.descStr  = jsonChildNode.optString("update").toString();
			    	tempSchData.timeStr= jsonChildNode.optString("time").toString();
                 toReturnList.add(tempSchData);
			    }
			    catch (JSONException e) {
			        e.printStackTrace();
			    }
			}
		 return toReturnList;
	 }
}
