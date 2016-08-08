package cn.mrxus.demo_zxing_2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by mrxus on 16/8/8.
 */
public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private ImageView iv;
    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.tv2);
        findViewById(R.id.bt).setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, CaptureActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        intent = getIntent();
        Bundle value = intent.getBundleExtra("value");
        if (value!=null) {
        String obj = value.getString("obj");
            tv.setText(obj);
        }
    }
}
