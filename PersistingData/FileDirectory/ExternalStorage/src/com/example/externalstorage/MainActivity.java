package com.example.externalstorage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//write to file
		try{
			if (IsExternalStorageAvailableAndWriteable()){
				File extStorage = Environment.getExternalStorageDirectory();
				File directory = new File (extStorage.getAbsolutePath() + "/MyFiles");
				directory.mkdirs();
				File file = new File(directory, "textfile.txt");
				FileOutputStream fOut =
						new FileOutputStream(file);
				OutputStreamWriter osw =
						new OutputStreamWriter(fOut);
				osw.write("The quick brown fox jumps over the lazy dog.\n");
				osw.write("Band of Brothers.");
				osw.flush();
				osw.close();
				Toast.makeText(getBaseContext(), "File saved successfully!", Toast.LENGTH_SHORT).show();
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//read from file
		try{
			if (IsExternalStorageAvailableAndWriteable()){
				File extStorage = Environment.getExternalStorageDirectory();
				File directory = new File (extStorage.getAbsolutePath() + "/MyFiles");
				File file = new File(directory, "textfile.txt");
				FileInputStream fIn = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fIn));
				String str = null;
				while((str = br.readLine())!=null){
					Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
				}
				fIn.close();
				br.close();
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public boolean IsExternalStorageAvailableAndWriteable(){
		boolean externalStorageAvailable = false;
		boolean externalStorageWriteable = false;
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)){
			externalStorageAvailable = externalStorageWriteable = true;
		}else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
			externalStorageAvailable = true;
			externalStorageWriteable = false;
		}else{
			externalStorageAvailable = externalStorageWriteable = false;
		}
		return externalStorageAvailable && externalStorageWriteable;
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
