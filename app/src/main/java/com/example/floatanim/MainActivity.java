package com.example.floatanim;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton floatPlus, floatBlue, floatWifi;
    private Animation fabOpen, fabClose, fabClock, fabAntiClock;
    private boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatPlus = findViewById(R.id.fab_plus);
        floatBlue = findViewById(R.id.fab_blue);
        floatWifi = findViewById(R.id.fab_wifi);
        setAnimation();
    }

    private void setAnimation() {
        fabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fabClock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clock_wise);
        fabAntiClock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlock_wise);
        fabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);

        floatPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isOpen) {
                    floatWifi.startAnimation(fabClose);
                    floatBlue.startAnimation(fabClose);
                    floatPlus.startAnimation(fabAntiClock);
                    floatWifi.setClickable(false);
                    floatBlue.setClickable(false);
                    isOpen = false;
                } else {
                    floatWifi.startAnimation(fabOpen);
                    floatBlue.startAnimation(fabOpen);
                    floatPlus.startAnimation(fabClock);
                    floatWifi.setClickable(true);
                    floatBlue.setClickable(true);
                    floatWifi.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "Wifi Clicked", Toast.LENGTH_SHORT).show();
                        }
                    });

                    floatBlue.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "Bluetooth Clicked", Toast.LENGTH_SHORT).show();
                        }
                    });
                    isOpen = true;
                }
            }
        });
    }
}
