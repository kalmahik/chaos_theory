package com.kalmahik.chaos_theory;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;
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

public class Level4Activity extends AppCompatActivity {
    private Button button;
    private int counter = 0;
    private int counter2 = 0;
    private RelativeLayout mainActivity;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1);

        SpannableString title = SpannableString.valueOf("Level 4");
        title.setSpan(new ForegroundColorSpan(0xffFF6F00), 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        CustomTypefaceSpan customTypefaceSpan = new CustomTypefaceSpan("halloween",
                Typeface.createFromAsset(getAssets(), "fonts/halloween.ttf"));
        title.setSpan(customTypefaceSpan, 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        title.setSpan(new RelativeSizeSpan(2f), 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        getSupportActionBar().setTitle(title);


        button = (Button) findViewById(R.id.button);

        nextButton = (Button) findViewById(R.id.button_next);

        nextButton.setVisibility(View.GONE);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/halloween.ttf");
        nextButton.setTypeface(typeFace);



        mainActivity = (RelativeLayout) findViewById(R.id.activity_main);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                counter2++;

                if (counter2 > 4){
                    try {
                        Thread.sleep(500);
                        vibrator.vibrate(100);
                        Thread.sleep(100);
                        vibrator.vibrate(100);
                        Thread.sleep(100);
                        vibrator.vibrate(100);//
                        Thread.sleep(500);
                        vibrator.vibrate(100);
                        Thread.sleep(500);
                        vibrator.vibrate(100);
                        Thread.sleep(500);
                        vibrator.vibrate(100);//
                        Thread.sleep(500);
                        vibrator.vibrate(100);
                        Thread.sleep(100);
                        vibrator.vibrate(100);
                        Thread.sleep(100);
                        vibrator.vibrate(100);
                        Thread.sleep(100);
                        counter2=0;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        });


        mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;


                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);

                if (counter > 4) {
                    click();
                    win();
                    nextButton.setVisibility(View.VISIBLE);

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
        SpannableString title = SpannableString.valueOf("Level 4");
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

        Intent intent = new Intent(Level4Activity.this, Level5Activity.class);
        startActivity(intent);
    }
}