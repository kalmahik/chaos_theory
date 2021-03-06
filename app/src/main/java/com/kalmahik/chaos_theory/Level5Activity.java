package com.kalmahik.chaos_theory;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Level5Activity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private int counter1 = 0;
    private int counter2 = 0;
    private RelativeLayout mainActivity;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_5);

        SpannableString title = SpannableString.valueOf("Level 5");
        title.setSpan(new ForegroundColorSpan(0xffFF6F00), 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        CustomTypefaceSpan customTypefaceSpan = new CustomTypefaceSpan("halloween",
                Typeface.createFromAsset(getAssets(), "fonts/halloween.ttf"));
        title.setSpan(customTypefaceSpan, 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        title.setSpan(new RelativeSizeSpan(2f), 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        getSupportActionBar().setTitle(title);



        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        nextButton = (Button) findViewById(R.id.button_next);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/halloween.ttf");
        nextButton.setTypeface(typeFace);


        nextButton.setVisibility(View.GONE);


        mainActivity = (RelativeLayout) findViewById(R.id.activity_main);

        mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1++;


                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);

                click();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;


                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);


                if (counter2 > 0 && counter1 > 0) {
                    win();
                    click();
                    nextButton.setVisibility(View.VISIBLE);
                    counter2 = 0;
                    counter1 = 0;



                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);

                next();
            }
        });

    }

    public void click() {
        SpannableString title = SpannableString.valueOf("Level 5");
        title.setSpan(new ForegroundColorSpan(0xff000000), 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        CustomTypefaceSpan customTypefaceSpan = new CustomTypefaceSpan("halloween",
                Typeface.createFromAsset(getAssets(), "fonts/halloween.ttf"));
        title.setSpan(customTypefaceSpan, 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        title.setSpan(new RelativeSizeSpan(2f), 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFFFF6F00));
    }

    public void errorClick() {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));

    }

    public void win() {
        Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();
    }

    public void next() {

        Intent intent = new Intent(Level5Activity.this, Level6Activity.class);
        startActivity(intent);
    }
}