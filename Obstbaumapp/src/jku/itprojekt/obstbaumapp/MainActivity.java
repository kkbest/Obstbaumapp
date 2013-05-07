package jku.itprojekt.obstbaumapp;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	WebView mWebView; // Webview which handles the main app
	TextView txterror;
	Button btnerror;
	String url;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startBrowser();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		url = "http://linz.pflueckt.at/";
		return true;
	}
	
	public void setSettings() {

		btnerror = (Button) findViewById(R.id.button1);
		btnerror.setVisibility(View.GONE);
		btnerror.setText("Reload");

		mWebView = (WebView) findViewById(R.id.webView1);
		// allow Javascript and Geolocation
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setGeolocationEnabled(true);
		
		
		mWebView.setWebViewClient(new WebViewClient() {

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				
				showToast(MainActivity.this, description, Toast.LENGTH_SHORT);

				//view.loadData("Keine Verbindung vorhanden", "text/html","utf-8");
				mWebView.loadData("Keine Verbindung vorhanden", "text/html","utf-8");

				btnerror.setVisibility(View.VISIBLE);
				btnerror.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						mWebView.loadUrl("http://obst.linzwiki.at/");
						btnerror.setVisibility(View.GONE);
						//showToast(MainActivity.this, "click", Toast.LENGTH_SHORT);
						//((WebView) v).loadUrl("http://obst.linzwiki.at/");
					}
				});
			}

		});
	}
	
	public void showToast(Context context, String text, int time)
	{
		Toast.makeText(this, text, time).show();
	}

	/**
	 * starting the Browser //main input
	 */
	public void startBrowser() {

		setSettings();
		mWebView.loadUrl("http://obst.linzwiki.at/");

	}

}
