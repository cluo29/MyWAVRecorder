package io.cluo29.github.mywavrecorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    private ExtAudioRecorder extAudioRecorder;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        extAudioRecorder = ExtAudioRecorder.getInstanse(false);

        ;


        findViewById(R.id.button).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                String fileName = System.currentTimeMillis() + ".wav";
                extAudioRecorder.setOutputFile(getApplicationContext().getExternalFilesDir(null)+ fileName);
                extAudioRecorder.prepare();
                extAudioRecorder.start();
                Log.d("WAV","123");
            }
        });

        findViewById(R.id.button2).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                extAudioRecorder.stop();
                extAudioRecorder.release();
                Log.d("WAV","321");
            }
        });
    }



}
