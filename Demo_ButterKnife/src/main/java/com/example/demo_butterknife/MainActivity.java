package com.example.demo_butterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bt)
    Button bt;
    @BindView(R.id.tv)
    Button tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        ButterKnife.setDebug(true);
        tv.setText("23");
    }

    @OnClick(R.id.bt)
    public void onClick(View view) {
        tv.setText("测试");
    }
}
