package com.example.actionbartabs;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();  
	    actionBar.setDisplayHomeAsUpEnabled(true);  
//	    setOverflowShowingAlways();  
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);  
	    Tab tab = actionBar  
	            .newTab()  
	            .setText("artist")  
	            .setTabListener(  
	                    new TabListener<ArtistFragment>(this, "artist",  
	                            ArtistFragment.class));  
	    actionBar.addTab(tab);  
	    tab = actionBar  
	            .newTab()  
	            .setText("album")  
	            .setTabListener(  
	                    new TabListener<AlbumFragment>(this, "album",  
	                            AlbumFragment.class));  
	    actionBar.addTab(tab);  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
