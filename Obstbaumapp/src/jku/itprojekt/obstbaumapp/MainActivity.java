package jku.itprojekt.obstbaumapp;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.webkit.WebView;

public class MainActivity extends Activity {

	
	WebView mWebView; // Webview which handles the main app
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startBrowser();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void setSettings() {

		mWebView = (WebView) findViewById(R.id.webView1);
		// allow Javascript and Geolocation
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setGeolocationEnabled(true);
	}

	/**
	 * starting the Browser //main input
	 */
	public void startBrowser() {

		setSettings();
		mWebView.loadUrl("http://obst.linzwiki.at/");

	}

}
