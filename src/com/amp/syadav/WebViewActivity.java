package com.amp.syadav;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class WebViewActivity extends Activity 
{
       WebView browser;
       String socialURL;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		
		headerSettings();
		
		Intent intent = getIntent();
		socialURL = intent.getStringExtra("SOCIAL_URL");
		browser = (WebView) findViewById(R.id.webView);
		browser.getSettings().setJavaScriptEnabled(true);
		browser.setWebViewClient(new CustomWebViewClient());
		
		
		if(socialURL != null)
		browser.loadUrl(socialURL);
	}
	 private class CustomWebViewClient extends WebViewClient{  //HERE IS THE MAIN CHANGE. 

	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            return (false);
	        }

	    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_view, menu);
		return true;
	}
	private void headerSettings() {
		findViewById(R.id.btnBackHeader).setVisibility(View.VISIBLE);
		findViewById(R.id.btnHomeHeader).setVisibility(View.GONE);	
		TextView headerTitle =(TextView)findViewById(R.id.txtHeading);
		headerTitle.setText(R.string.title_activity_web_view);
	}
	public void gotoBack(View v){
		finish();
	}
}
