package com.kalmahik.chaos_theory;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Level9Activity extends AppCompatActivity {
    private Button button;
    private int counter = 0;
    private RelativeLayout mainActivity;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1);

        getSupportActionBar().setTitle("Level 999");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));


        button = (Button) findViewById(R.id.button);

        nextButton = (Button) findViewById(R.id.button_next);

        nextButton.setVisibility(View.GONE);


        mainActivity = (RelativeLayout) findViewById(R.id.activity_main);

        mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        });


        button.setOnTouchListener(new View.OnTouchListener() {
            long startTime;


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: // нажатие
                        startTime = System.currentTimeMillis();
                        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        vibrator.vibrate(100);
                        break;
                    case MotionEvent.ACTION_MOVE: // движение
                        break;
                    case MotionEvent.ACTION_UP: // отпускание
                    case MotionEvent.ACTION_CANCEL:
                        long totalTime = System.currentTimeMillis() - startTime;
                        long totalSecunds = totalTime / 1000;
                        if (totalSecunds >= 3) {
                            click();
                            win();
                            nextButton.setVisibility(View.VISIBLE);
                        }
                        break;
                }
                return true;
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);

                next();
            }
        });

    }

    public void click() {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
    }

    public void errorClick() {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));

    }

    public void win() {
        Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();
    }

    public void next() {

        Intent intent = new Intent(Level9Activity.this, Level10Activity.class);
        startActivity(intent);
    }
}