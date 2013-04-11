package jku.itprojekt.obstbaumapp;


import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

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
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void setSettings() {

		mWebView = (WebView) findViewById(R.id.webView1);
		// Banner
		
		// Zoom deaktivieren
		//mWebView.getSettings().setSupportZoom(false);
		//mWebView.getSettings().setBuiltInZoomControls(false);

		// set User-Agent with package-name & versionname
		try {
			mWebView.getSettings().setUserAgentString(
					getPackageName()
							+ " "
							+ getPackageManager().getPackageInfo(
									getPackageName(), 0).versionName);
		} catch (NameNotFoundException e) {

			e.printStackTrace();
		}
		// allow Javascript and Geolocation
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setGeolocationEnabled(true);
		// add a new JavaspriptInterface.
	}

	/**
	 * starting the Browser //main input
	 */
	public void startBrowser() {

		setSettings();
		mWebView.loadUrl("http://go.yuri.at/obst/");

	}

}
