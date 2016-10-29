package com.kalmahik.chaos_theory;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

public class Level8Activity extends AppCompatActivity {
    private Button button;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_8);

        button = (Button) findViewById(R.id.button);


        button.setOnTouchListener(new View.OnTouchListener(){

            long startTime;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: // нажатие
                        startTime = System.currentTimeInMills();
                        break;
                    case MotionEvent.ACTION_MOVE: // движение
                        break;
                    case MotionEvent.ACTION_UP: // отпускание
                    case MotionEvent.ACTION_CANCEL:
                        long totalTime = System.currentTimeInMills() - startTime;
                        long totalSecunds = totalTime / 1000;
                        if( totalSecunds >= 3 )
                        {
                            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
                            win();
                            next();
                        }
                        break;
                }
                return true;
            }
        });




        getSupportActionBar().setTitle("Level 8");

    }

    public void click() {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }

    public void win() {
        Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();
    }

    public void next() {
        Intent intent = new Intent(Level8Activity.this, Level9Activity.class);
        startActivity(intent);
    }
}
