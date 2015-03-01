package com.amp.syadav;





import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class WebViewActivity extends Activity 
{
	WebView browser;
	String socialURL,currentTitle;
	ProgressBar progress;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		System.out.println("WebViewActivity.onCreate()");
		//progress.setVisibility(View.GONE);
		Intent intent = getIntent();
		socialURL = intent.getStringExtra("SOCIAL_URL");
		currentTitle= intent.getStringExtra("TITLE");
		headerSettings();
		progress = (ProgressBar) findViewById(R.id.progressBar);
		progress.setMax(100);



		browser = (WebView) findViewById(R.id.webView);
		browser.setWebViewClient(new CustomWebViewClient());
		browser.getSettings().setJavaScriptEnabled(true);
		if(socialURL != null)
			browser.loadUrl(socialURL);	
	}



	private class CustomWebViewClient extends WebViewClient{  //HERE IS THE MAIN CHANGE. 

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			progress.setVisibility(View.VISIBLE);
			view.loadUrl(url);
			return true;
		}
		@Override
		public void onPageFinished(WebView view, String url) {
			progress.setVisibility(View.GONE);
			super.onPageFinished(view, url);
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			progress.setVisibility(View.VISIBLE);

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
		headerTitle.setText(currentTitle);
	}
	public void gotoBack(View v){
		finish();
	}
	public void setValue(int progress) {
		this.progress.setProgress(progress);		
	}


}
