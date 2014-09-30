package com.example.savingfilestodatadirectory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	static final int READ_BLOCK_SIZE = 100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//write to files
		//directory:/data/data/<package_name>/files
		try {
			FileOutputStream fOut = openFileOutput("textfile.txt", MODE_PRIVATE);
			OutputStreamWriter osw = new OutputStreamWriter(fOut);
			osw.write("The quick brown fox jumps over the lazy dog");
			osw.close();
			Toast.makeText(getBaseContext(), "File saved successfully!", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//read from file
		try {
			FileInputStream fIn = openFileInput("textfile.txt");
			InputStreamReader isr = new InputStreamReader(fIn);
			char[] inputBuffer = new char[READ_BLOCK_SIZE];
			String s = "";
			int charRead;
			while((charRead = isr.read(inputBuffer))>0){
				String readString = 
						String.copyValueOf(inputBuffer, 0, charRead);
				s += readString;
				inputBuffer = new char[READ_BLOCK_SIZE];
			}
			isr.close();
			
			Toast.makeText(getBaseContext(), "File loaded successfully!"+s,
					Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
