package com.kalmahik.chaos_theory;

/**
 * Created by днс on 29.10.2016.
 */

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


public class Level8Activity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private int counter1 = 0;
    private int counter2 = 0;
    private int counter3 = 0;
    private Button buttonNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_8);

        RelativeLayout mainActivity = (RelativeLayout) findViewById(R.id.activity_main);

        mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        });


        button1 = (Button) findViewById(R.id.button1);
        buttonNext = (Button) findViewById(R.id.button_next);
        buttonNext.setVisibility(View.GONE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                counter1++;

            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                counter2++;
                if (counter1 ==1){

                }

            }
        });

        getSupportActionBar().setTitle("Level 8");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));


        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                counter3++;


                if (counter1==1){
                    if (counter2==1){
                        if(counter3==1){
                            win();
                            buttonNext.setVisibility(View.VISIBLE);
                            next();

                        }
                    }
                }
                counter2=0;
                counter1=0;
                counter3=0;

            }


        });

    }


    public void win() {
        Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();
    }

    public void click() {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }

    public void next() {
        Intent intent = new Intent(Level8Activity.this, Level9Activity.class);
        startActivity(intent);
    }

}