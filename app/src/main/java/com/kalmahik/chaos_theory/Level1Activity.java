package com.kalmahik.chaos_theory;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Level1Activity extends AppCompatActivity {
    private Button button;
    private int counter = 0;
    private RelativeLayout mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1);

        getSupportActionBar().setTitle("Level 1");

        button = (Button) findViewById(R.id.button);

        mainActivity = (RelativeLayout) findViewById(R.id.activity_main);
        mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                clickButton();

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);

                if (counter > 0) {
                    win();
                    next();
                    click();
                }
            }
        });
    }

    public void clickButton(){
        button.setBackgroundColor(0xff0000);
    }

    public void click() {
        //Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
    }

    public void errorClick() {
        //Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));

    }

    public void win() {
        Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();
    }

    public void next() {
        Intent intent = new Intent(Level1Activity.this, Level2Activity.class);
        startActivity(intent);
    }
}