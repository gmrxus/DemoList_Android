package cn.mrxus.demo_vitamio;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

import io.vov.vitamio.*;
import io.vov.vitamio.provider.MediaStore;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by mrxus on 16/8/19.
 */
public class VitamioActivity extends AppCompatActivity implements View.OnClickListener {
    private VideoView videoView;
    private String uriMp3 = "http://res.91mm.fm/audio/userInfo/11/1066.mp3";
    public static final String uriMp4 = "http://player.youku.com/player.php/sid/XMzI2NTc4NTMy/v.swf";
    private Button start;
    private Button suspend;
    private String romPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamio);
        findView();
        setData();
    }

    private void findView() {
        videoView = (VideoView) findViewById(R.id.vitamio_videoView);
        start = (Button) findViewById(R.id.start);
        suspend = (Button) findViewById(R.id.suspend);
//        findViewById(R.id.best1).setOnClickListener(this);
//        findViewById(R.id.best2).setOnClickListener(this);
//        findViewById(R.id.best3).setOnClickListener(this);

        start.setOnClickListener(this);
        suspend.setOnClickListener(this);

    }

    private void setData() {
        romPath = SDCardUtil.getSDCardPath() + "临时/" + "demo.mp4";
        Log.d("VitamioActivity", romPath);
        if (new File(romPath).exists()) {
            Toast.makeText(this, romPath, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "文件不存在", Toast.LENGTH_SHORT).show();
        }

//        MediaController controller = new MediaController(this);
//        controller.show();
//        videoView.setMediaController(controller);



    }

    @Override
    protected void onStart() {
        super.onStart();
        videoView.pause();


    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();

    }

    boolean isLoad=false;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:

                if(!isLoad){
                    videoView.setVideoPath(romPath);
                    isLoad=true;
                }


                videoView.start();
                break;
            case R.id.suspend:
                videoView.pause();
                break;
//            case R.id.best1:
//                videoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);
//                break;
//            case R.id.best2:
//                videoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_MEDIUM);
//                break;
//            case R.id.best3:
//                videoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_LOW);
//                break;
        }
    }
}
