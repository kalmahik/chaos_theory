package com.kalmahik.chaos_theory;


import android.content.Context;
import android.content.Intent;
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
    private Button nextButton;
    private RelativeLayout mainActivity;
    private int counter1 = 0;
    private int counter2 = 0;
    private int counter3 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_8);

        button1 = (Button) findViewById(R.id.button1);

        getSupportActionBar().setTitle("Level 8");


        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter1 == 1) {
                    counter1 = 0;
                }
                counter1 = 1;
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter2 == 1) {
                    counter2 = 0;
                    counter1 = 0;
                }
                if (counter1 == 1) {
                    counter2 = 1;
                }

            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter1 == 1 && counter2 == 1 && counter3 == 1)
                {
                    counter3 = 2;
                }
                if (counter3 == 1) {
                    counter3 = 0;
                    counter2 = 0;
                    counter1 = 0;
                }


                if (counter3 == 2) {
                    win();
                    click();
                    nextButton.setVisibility(View.VISIBLE);
                }

            }


        });


        nextButton = (Button) findViewById(R.id.button_next);

        nextButton.setVisibility(View.GONE);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);

                next();
            }
        });


        mainActivity = (RelativeLayout) findViewById(R.id.activity_main);

        mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
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