package com.music.lqg.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class HomeActivity extends AppCompatActivity {
   private MediaPlayer mediaPlayer = new MediaPlayer();
    private Button bt_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initMediaPlayer();

       bt_start = (Button) findViewById(R.id.bt_start);
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bt_last:
                        break;
                    case R.id.bt_start: {
                        if (!mediaPlayer.isPlaying()) {
                            mediaPlayer.start();
                            Log.i("homeactivity","启动音乐");
                        }else{
                            mediaPlayer.pause();
                        }
                    }
                    break;
                    case R.id.bt_next:
                        break;
                }
            }
        });
    }



    private void initMediaPlayer() {
//        mediaPlayer.reset();
        File file = new File(Environment.getExternalStorageDirectory(),"1.mp3");
        try {
            mediaPlayer.setDataSource(file.getPath());
//            mediaPlayer.setOnPreparedListener(MediaPlayer.OnPreparedListener);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

