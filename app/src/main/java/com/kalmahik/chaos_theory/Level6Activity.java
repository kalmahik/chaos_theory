package com.kalmahik.chaos_theory;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Level6Activity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private int counter1 = 0;
    private int counter2 = 0;
    private RelativeLayout mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_5);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        mainActivity = (RelativeLayout) findViewById(R.id.activity_main);


        getSupportActionBar().setTitle("Level 6");


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1++;
            }
        });


        mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;
                if (counter2 > 2 && counter1 > 2) {
                    click();
                    win();
                    next();

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
        Intent intent = new Intent(Level6Activity.this, Level7Activity.class);
        startActivity(intent);
    }

}
