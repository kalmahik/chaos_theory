package com.kalmahik.chaos_theory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Level1Activity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                win();
                Intent intent = new Intent(Level1Activity.this, Level2Activity.class);
                startActivity(intent);
            }
        });
    }


    public void win(){
        Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();

    }
}
