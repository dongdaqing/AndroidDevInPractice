package ddq.audiorecord;

import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    private Button record, stop;
    private File myRecAudioFile;
    private File myRecAudioDir;
    private MediaRecorder mMediaRecorder01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecAudioDir = Environment.getExternalStorageDirectory();

        record = (Button)findViewById(R.id.record);
        stop = (Button)findViewById(R.id.stop);

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    myRecAudioFile = File.createTempFile("ddq",".amr",myRecAudioDir);

                    mMediaRecorder01 = new MediaRecorder();
                    mMediaRecorder01
                            .setAudioSource(MediaRecorder.AudioSource.MIC);
                    mMediaRecorder01
                            .setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
                    mMediaRecorder01
                            .setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                    mMediaRecorder01
                            .setOutputFile(myRecAudioFile.getAbsolutePath());
                    mMediaRecorder01.prepare();
                    mMediaRecorder01.start();
                }catch (IOException e){
                    e.printStackTrace();
                }


            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myRecAudioFile != null){
                    mMediaRecorder01.stop();
                    mMediaRecorder01.release();
                }
            }
        });
    }



}
