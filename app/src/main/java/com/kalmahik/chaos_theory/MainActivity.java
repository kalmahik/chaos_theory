package com.kalmahik.chaos_theory;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView logo;
TextView inter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = (TextView) findViewById(R.id.logo);
        inter = (TextView) findViewById(R.id.inter);

        getSupportActionBar().hide();

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/halloween.ttf");
        logo.setTypeface(typeFace);

        inter.setTypeface(typeFace);


        inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);

                next();
            }
        });

    }

    public void next() {

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
}
