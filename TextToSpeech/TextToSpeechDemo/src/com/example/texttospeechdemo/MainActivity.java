package com.example.texttospeechdemo;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements OnInitListener{
	
	private EditText textToSpeak;
	private Button btnSpeak;
	private TextToSpeech mTts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textToSpeak = (EditText)findViewById(R.id.wordspeak);
        btnSpeak = (Button)findViewById(R.id.btn);
        mTts = new TextToSpeech(this,this);
        btnSpeak.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String text = textToSpeak.getText().toString();
				speak(text);
			}
        	
        });
    }
    
    private void speak(String textToSpeak){
        mTts.speak(textToSpeak, TextToSpeech.QUEUE_FLUSH, null);	
     }

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		// status can be either TextToSpeech.SUCCESS or TextToSpeech.ERROR
        if (status == TextToSpeech.SUCCESS) {
            // Set preferred language to US english.
            // Note that a language may not be available, and the result will indicate this.
            int result = mTts.setLanguage(Locale.CHINA);
            
            if (result == TextToSpeech.LANG_MISSING_DATA ||
                result == TextToSpeech.LANG_NOT_SUPPORTED) {
               // Lanuage data is missing or the language is not supported.
                Log.e("404","Language is not available.");
            }
        } else {
            // Initialization failed.
            Log.e("404", "Could not initialize TextToSpeech.");
            // May be its not installed so we prompt it to be installed
            Intent installIntent = new Intent();
            installIntent.setAction(
                TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
            startActivity(installIntent);
        }
	}
	
	@Override
    public void onDestroy() {
        if (mTts != null) {
            mTts.stop();
            mTts.shutdown();
        }
        super.onDestroy();
    }
}
