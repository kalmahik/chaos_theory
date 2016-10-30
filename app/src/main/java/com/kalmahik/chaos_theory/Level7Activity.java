package com.kalmahik.chaos_theory;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Level7Activity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private int counter = 0;
    private Button nextButton;
    private RelativeLayout mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_7);

        mainActivity = (RelativeLayout) findViewById(R.id.activity_main);

        mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        });

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);



        button2.setClickable(false);
        button2.setVisibility(View.GONE);

        button3.setClickable(false);
        button3.setVisibility(View.GONE);

        button4.setClickable(false);
        button4.setVisibility(View.GONE);

        button5.setClickable(false);
        button5.setVisibility(View.GONE);

        nextButton = (Button) findViewById(R.id.button_next);
        nextButton.setVisibility(View.GONE);

        getSupportActionBar().setTitle("Level 7");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                button1.setClickable(false);
                button1.setVisibility(View.GONE);
                button2.setVisibility(View.VISIBLE);
                button2.setClickable(true);
                button3.setVisibility(View.VISIBLE);
                button3.setClickable(true);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                button2.setVisibility(View.GONE);
                button2.setClickable(false);
                button4.setVisibility(View.VISIBLE);
                button4.setClickable(true);
                button5.setVisibility(View.VISIBLE);
                button5.setClickable(true);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                counter++;
                if (counter == 3) {
                    click();
                    win();
                    button1.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                    button4.setVisibility(View.GONE);
                    button5.setVisibility(View.GONE);

                    nextButton.setVisibility(View.VISIBLE);

                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                restart();
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
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFFFF6F00));
    }

    public void win() {
        Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();
    }

    public void next() {
        Intent intent = new Intent(Level7Activity.this, Level8Activity.class);
        startActivity(intent);
    }

    public void restart() {
        Intent intent = new Intent(Level7Activity.this, Level7Activity.class);
        startActivity(intent);
    }
}