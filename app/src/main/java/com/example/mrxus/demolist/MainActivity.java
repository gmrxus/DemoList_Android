package com.example.mrxus.demolist;

import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mrxus.demolist.http.HttpUtil;
import com.example.mrxus.demolist.http.RequestBody;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findViewById(R.id.bt).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        RequestBody body=RequestBody.create()
                .add("a","2")
                .add("b","3")
                .build();



    }


    private class DataPickerFragment extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return super.onCreateDialog(savedInstanceState);


        }
    }
}
