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

public class Level5Activity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private int counter1 = 0;
    private int counter2 = 0;
    private RelativeLayout mainActivity;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_5);

        getSupportActionBar().setTitle("Level 5");

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

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


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1++;
                button1.setBackgroundColor(0xffff0000);


                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);

                click();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;
                button2.setBackgroundColor(0xffff0000);


                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);


                if (counter2 > 0 && counter1 > 0) {
                    win();
                    click();
                    nextButton.setVisibility(View.VISIBLE);

                }
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

        Intent intent = new Intent(Level5Activity.this, Level6Activity.class);
        startActivity(intent);
    }
}