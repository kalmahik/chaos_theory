package com.kalmahik.chaos_theory;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Level4Activity extends AppCompatActivity {
    private Button button;
    private int counter = 0;
    private RelativeLayout mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_2);

        getSupportActionBar().setTitle("Level 4");

        button = (Button) findViewById(R.id.button);

        mainActivity = (RelativeLayout) findViewById(R.id.activity_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // error_click();
            }
        });

        mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if (counter > 5) {
                    win();
                    next();
                    click();

                }
            }
        });
    }

    public void click() {
        //Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
    }

    public void error_click() {
        //Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));

    }

    public void win() {
        Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();
    }

    public void next() {
        Intent intent = new Intent(Level4Activity.this, Level5Activity.class);
        startActivity(intent);
    }
}