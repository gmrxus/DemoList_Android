package cn.mrxus.demo_vitamio;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.vov.vitamio.widget.VideoView;

/**
 * Created by mrxus on 16/8/19.
 */
public class VitamioActivity extends AppCompatActivity {
    private VideoView videoView;
    private String uriMp3="http://res.91mm.fm/audio/userInfo/11/1066.mp3";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamio);
        findView();
        setData();
    }
    private void findView() {
        videoView = (VideoView)findViewById(R.id.vitamio_videoView);

    }

    private void setData() {
        Uri uri=Uri.parse(uriMp3);
        videoView.setVideoURI(uri);
    }


}
