package com.kalmahik.chaos_theory;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by PolyProgrammist on 30.10.2016.
 */

public class Level13Activity extends AppCompatActivity{
    Button button;
    MediaPlayer mp;
    private Button nextButton;
    private LinearLayout mainActivity;
    private static boolean was = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_13);
        button = (Button) findViewById(R.id.button13);


        SpannableString title = SpannableString.valueOf("Level 13");
        title.setSpan(new ForegroundColorSpan(0xffFF6F00), 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        CustomTypefaceSpan customTypefaceSpan = new CustomTypefaceSpan("halloween",
                Typeface.createFromAsset(getAssets(), "fonts/halloween.ttf"));
        title.setSpan(customTypefaceSpan, 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        //title.setSpan(new LinearSizeSpan(2f), 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        getSupportActionBar().setTitle(title);

        nextButton = (Button) findViewById(R.id.button_next13);

        nextButton.setVisibility(View.GONE);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/halloween.ttf");
        nextButton.setTypeface(typeFace);


        mainActivity = (LinearLayout) findViewById(R.id.ddd13);

        mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        });
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent me) {
                if (me.getAction() == MotionEvent.ACTION_MOVE && v == button) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(v.getWidth(), v.getHeight());
                    params.setMargins((int) me.getRawX() - v.getWidth() / 2, (int) (me.getRawY() - v.getHeight() * 1.5), (int) me.getRawX() - v.getWidth() / 2, (int) (me.getRawY() - v.getHeight() * 1.5));
                    v.setLayoutParams(params);
                    Display display = getWindowManager().getDefaultDisplay();
                    Point size = new Point();
                    display.getSize(size);
                    int width = size.x;
                    int height = size.y;
                    if (!was) {
                        if (me.getRawX() + v.getWidth() >= width - 10 && me.getRawY() + v.getHeight() >= height - 10) {
                            win();
                            was = true;
                        }
                    }
                }
                return true;
            }
        });
    }
    public void win() {
        Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();
    }
}
