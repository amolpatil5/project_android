package com.amp.syadav;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class VideoGallaryActivity extends Activity 
{
	WebView webview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_gallary);
		headerSettings();
		webview = (WebView) findViewById(R.id.videoWebView);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.setWebViewClient(new VideoWebViewClient());
		webview.loadUrl("https://www.youtube.com/user/shivpalsinghyad");
	}
	 private class VideoWebViewClient extends WebViewClient{  //HERE IS THE MAIN CHANGE. 

	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            return (false);
	        }
	    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.video_gallary, menu);
		return true;
	}
	private void headerSettings() {
		findViewById(R.id.btnBackHeader).setVisibility(View.VISIBLE);
		findViewById(R.id.btnHomeHeader).setVisibility(View.GONE);	
		TextView headerTitle =(TextView)findViewById(R.id.txtHeading);
		headerTitle.setText(R.string.title_activity_video_gallary);
	}
	public void gotoBack(View v){
		finish();
	}
}
