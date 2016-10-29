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

public class Level7Activity extends AppCompatActivity {
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

    }

}
