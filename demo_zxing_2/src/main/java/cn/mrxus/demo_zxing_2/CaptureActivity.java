package cn.mrxus.demo_zxing_2;

import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import cn.mrxus.demo_zxing_2.camera.CameraManager;
import cn.mrxus.demo_zxing_2.decoding.CaptureActivityHandler;
import cn.mrxus.demo_zxing_2.decoding.InactivityTimer;
import cn.mrxus.demo_zxing_2.view.ViewfinderView;


public class CaptureActivity extends FragmentActivity implements SurfaceHolder.Callback {

    private ViewfinderView viewfinderView;
    private CameraManager cameraManager;
    private TextView tv;
    private MediaPlayer mediaPlayer;
    private boolean hasSurface;
    private InactivityTimer inactivityTimer;
    private String characterSet;
    private CaptureActivityHandler handler;
    private Map<DecodeHintType, ?> decodeHints;
    private Collection<BarcodeFormat> decodeFormats;
    private boolean playBeep;
    private static final float BEEP_VOLUME = 0.10f;
    private boolean vibrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hasSurface = false;
        cameraManager = new CameraManager(getApplication());
        viewfinderView = (ViewfinderView) findViewById(R.id.viewfinderView);
        tv = (TextView) findViewById(R.id.tv);
        inactivityTimer = new InactivityTimer(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.sv);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        if (hasSurface) {
            initCamera(surfaceHolder);
        } else {
            surfaceHolder.addCallback(this);
        }
        decodeFormats =null;
        characterSet =null;

        playBeep =true;
        AudioManager audioService = (AudioManager) getSystemService(AUDIO_SERVICE);
        if (audioService.getRingerMode() != AudioManager.RINGER_MODE_NORMAL) {
            playBeep =false;
        }
        initBeepSound();
        vibrate =true;
    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        try {
            cameraManager.openDriver(surfaceHolder);

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        if (handler == null) {

            handler = new CaptureActivityHandler(this, decodeFormats, decodeHints, characterSet, cameraManager);
            surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        }


    }

    private void initBeepSound() {
        if (playBeep && mediaPlayer == null) {
            // The volume on STREAM_SYSTEM is not adjustable, and users found it
            // too loud,
            // so we now play on the music stream.
            this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(beepListener);

            AssetFileDescriptor file = getResources().openRawResourceFd(
                    R.raw.beep);
            try {
                mediaPlayer.setDataSource(file.getFileDescriptor(),
                        file.getStartOffset(), file.getLength());
                file.close();
                mediaPlayer.setVolume(BEEP_VOLUME, BEEP_VOLUME);
                mediaPlayer.prepare();
            } catch (IOException e) {
                mediaPlayer = null;
            }
        }
    }

    private final MediaPlayer.OnCompletionListener beepListener = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    };

    //************surfaceView 的回调****************
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!hasSurface) {
            hasSurface =true;
            initCamera(surfaceHolder);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        hasSurface =false;
    }
    //**********************************************
}
