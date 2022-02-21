package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    float brightness=10f;

    Button btnSpin;
    ImageView ivWheel;
    CountDownTimer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSpin=findViewById(R.id.btnSpin);
        ivWheel=findViewById(R.id.ivWheel);

        Random random=new Random();

        btnSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSpin.setEnabled(false);

                // Random values blw 10 to 30
                int spin =random.nextInt(20)+10;

                // since the wheel has 10 divisions, the
                // rotation should be a multiple of
                // 360/10 = 36 degrees
                spin=spin*36;

                timer=new CountDownTimer(spin*5,1) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        float rotation=ivWheel.getRotation()+2.5f;
                        ivWheel.setRotation(rotation);
                    }

                    @Override
                    public void onFinish() {
                        btnSpin.setEnabled(true);
                    }
                }.start();
            }
        });

        //screenBright(brightness);
    }

    private void screenBright(float brightness) {
        WindowManager.LayoutParams layoutParams=getWindow().getAttributes();
        layoutParams.screenBrightness=brightness;
        getWindow().setAttributes(layoutParams);
    }


}