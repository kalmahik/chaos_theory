package com.kalmahik.chaos_theory;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    }
}
