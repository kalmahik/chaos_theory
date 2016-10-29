package com.kalmahik.chaos_theory;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

public class Level1Activity extends AppCompatActivity {
    private Button button;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_level_1);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
                win();
                next();
            }
        });

        getSupportActionBar().setTitle("Level 1");

    }

    public void click() {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }

    public void win() {
        Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();
    }

    public void next() {
        Intent intent = new Intent(Level1Activity.this, Level2Activity.class);
        startActivity(intent);
    }
}
