package com.example.mrxus.demolist;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.orhanobut.logger.Logger;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();
    }

    private void init() {
        findViewById(R.id.bt).setOnClickListener(this);
        findViewById(R.id.bt1).setOnClickListener(this);


        timer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {
                Logger.e("onTick"+l/1000);
            }

            @Override
            public void onFinish() {
                Logger.e("onFinish");
            }

        };

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt:
                timer.start();
                break;
            case R.id.bt1:
                Toast.makeText(this, "bt1", Toast.LENGTH_SHORT).show();
                timer.cancel();
                break;
        }

    }
}
