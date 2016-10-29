package com.kalmahik.chaos_theory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Level6Activity extends AppCompatActivity{
    private Button button1;
    private Button button2;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1);

        getSupportActionBar().setTitle("Level 6");


        button1 = (Button) findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                click();
                if (counter > 3) {
                    win();
                    next();
                }
            }
        });

      //  button2 = (Button) findViewById(R.id.button);

        /*button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                click();
                if (counter > 19) {
                    win();
                    next();
                }
            }
        });*/

    }


    public void win() {
        Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();
    }

    public void click() {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }

    public void next() {
        Intent intent = new Intent(Level6Activity.this, Level6Activity.class);
        startActivity(intent);
    }
}
