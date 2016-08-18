package com.evt.demo_utils;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.evt.demo_utils.utils.HttpUtil;
import com.evt.demo_utils.utils.SDCardUtil;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 100:
                    Toast.makeText(MainActivity.this, "msg.obj:" + msg.obj, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt1:
                String url = "http://op.juhe.cn/onebox/weather/query";
                HttpUtil.RequestBody body = HttpUtil.RequestBody.create()
                        .add("cityname", "武汉")
                        .add("key", "2727531d9f2ac6a83bb059adb5b6535f")
                        .add("dtype", "")
                        .build();

                HttpUtil.post(url, body, new HttpUtil.OnNetRequestListener() {
                    @Override
                    public void onSuccess(String returnValue) {
                        Message msg = new Message();
                        msg.obj = returnValue;
                        msg.what = 100;
                        mHandler.sendMessage(msg);
                    }

                    @Override
                    public void onFail() {

                    }
                });
                break;
            case R.id.bt2:

                break;
        }

    }
}
