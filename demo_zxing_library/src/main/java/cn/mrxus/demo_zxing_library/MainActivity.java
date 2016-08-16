package cn.mrxus.demo_zxing_library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private int REQUEST_CODE =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findViewById(R.id.bt_scanner).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), REQUEST_CODE);
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(REQUEST_CODE==requestCode){
            Bundle mBundle = data.getExtras();
            if(mBundle!=null){
                if (mBundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = mBundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (mBundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }

        }
    }
}
