package com.kalmahik.chaos_theory;

/**
 * Created by днс on 29.10.2016.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Level8Activity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private int counter1_1 = 0;
    private int counter1_2 = 0;
    private int counter1_3 = 0;
    private int counter2_1 = 0;
    private int counter2_2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_8);

        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1_1++;
                if (counter1_3 > 0)
                {
                    counter2_1++;
                }
//                if (counter1 > 1) {
//                    win();
//                    next();
//                }
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter1_1 > 0) {
                    counter1_2++;
                    counter1_1 = 0;
                }

                if(counter2_1 > 0){
                    counter2_2++;
                    counter2_1 = 0;
                }

//                click();
//                if(counter1 > 0)
//                {
//                    win();
//                    next();
//                }
                /*if (counter > 19) {
                    win();
                    next();
                }*/
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                if (counter1_2 > 0){
                    counter1_3++;
                    counter1_2 = 0;
                }
                if(counter2_2 > 0)
                {
                    counter2_2 = 0;
                    click();
                    win();
                    next();
                }

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