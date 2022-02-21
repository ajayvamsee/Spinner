package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    float brightness=10f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //screenBright(brightness);
    }

    private void screenBright(float brightness) {
        WindowManager.LayoutParams layoutParams=getWindow().getAttributes();
        layoutParams.screenBrightness=brightness;
        getWindow().setAttributes(layoutParams);
    }


}