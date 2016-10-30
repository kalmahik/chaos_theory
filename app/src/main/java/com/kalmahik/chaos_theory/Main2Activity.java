package com.kalmahik.chaos_theory;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView sure;
    TextView yes;
    TextView no;
    TextView inter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        sure = (TextView) findViewById(R.id.sure);
        yes = (TextView) findViewById(R.id.yes);
        no = (TextView) findViewById(R.id.no);

        getSupportActionBar().hide();

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/halloween.ttf");
        sure.setTypeface(typeFace);
        yes.setTypeface(typeFace);
        no.setTypeface(typeFace);

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);

                next();
            }
        });


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);

                finish();
            }
        });


    }

    public void next() {

        Intent intent = new Intent(Main2Activity.this, Level1Activity.class);
        startActivity(intent);
    }
}
