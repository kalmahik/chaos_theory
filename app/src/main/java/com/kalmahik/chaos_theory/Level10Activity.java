package com.kalmahik.chaos_theory;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Camera;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Level10Activity extends AppCompatActivity implements
        SurfaceHolder.Callback, Camera.PictureCallback,
        Camera.PreviewCallback, Camera.AutoFocusCallback{
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private int counter1 = 0;
    private int counter2 = 0;
    private int counter3 = 0;
    private int counter4 = 0;
    private int vibroCounter = 0;
    private RelativeLayout mainActivity;
    private Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_10);


        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        nextButton = (Button) findViewById(R.id.button_next);

        nextButton.setVisibility(View.GONE);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/halloween.ttf");
        nextButton.setTypeface(typeFace);
        mainActivity = (RelativeLayout) findViewById(R.id.activity_main);
        mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibroCounter++;
                if (vibroCounter > 9) {
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(10000);
                    vibroCounter = 0;
                }

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
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter3++;
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter4++;
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                if (counter1 > 0 && counter2 > 0 && counter3 > 0 && counter4 > 0) {
                    click();
                    win();
                    nextButton.setVisibility(View.VISIBLE);
                    next();
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

        SpannableString title = SpannableString.valueOf("Level 10");
        title.setSpan(new ForegroundColorSpan(0xffFF6F00), 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        CustomTypefaceSpan customTypefaceSpan = new CustomTypefaceSpan("halloween",
                Typeface.createFromAsset(getAssets(), "fonts/halloween.ttf"));
        title.setSpan(customTypefaceSpan, 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        title.setSpan(new RelativeSizeSpan(2f), 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        getSupportActionBar().setTitle(title);
        f();

    }

    public void click() {
        SpannableString title = SpannableString.valueOf("Level 10");
        title.setSpan(new ForegroundColorSpan(0xff000000), 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        CustomTypefaceSpan customTypefaceSpan = new CustomTypefaceSpan("halloween",
                Typeface.createFromAsset(getAssets(), "fonts/halloween.ttf"));
        title.setSpan(customTypefaceSpan, 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        title.setSpan(new RelativeSizeSpan(2f), 0, title.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFFFF6F00));
    }

    public void win() {
        Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();
        g();
    }

    void g(){
        camera.takePicture(null, null, null, this);
        ViewGroup.LayoutParams lp = preview.getLayoutParams();


        lp.width = ((RelativeLayout) findViewById(R.id.activity_main)).getWidth();
        lp.height = ((RelativeLayout) findViewById(R.id.activity_main)).getHeight();

        preview.setLayoutParams(lp);
    }

    public void next() {
        Intent intent = new Intent(Level10Activity.this, Level11Activity.class);
        startActivity(intent);
    }

    private Camera camera;
    private SurfaceHolder surfaceHolder;
    private SurfaceView preview;

    public void f()
    {
        preview = (SurfaceView) findViewById(R.id.SurfaceView01);

        surfaceHolder = preview.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        camera = Camera.open(1);
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        if (camera != null)
        {
            camera.setPreviewCallback(null);
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int
            width, int height)
    {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        try
        {
            camera.setPreviewDisplay(holder);
            camera.setPreviewCallback(this);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        float aspect = (float) previewSize.width / previewSize.height;

        int previewSurfaceWidth = preview.getWidth();
        int previewSurfaceHeight = preview.getHeight();

        ViewGroup.LayoutParams lp = preview.getLayoutParams();

        // здесь корректируем размер отображаемого preview, чтобы небыло искажений

        if (this.getResources().getConfiguration().orientation !=
                Configuration.ORIENTATION_LANDSCAPE)
        {
            // портретный вид
            camera.setDisplayOrientation(90);
            lp.height = previewSurfaceHeight;
            lp.width = (int) (previewSurfaceHeight / aspect);
            ;
        }
        else
        {
            // ландшафтный
            camera.setDisplayOrientation(0);
            lp.width = previewSurfaceWidth;
            lp.height = (int) (previewSurfaceWidth / aspect);
        }
        lp.width = 0;
        lp.height = 0;

        preview.setLayoutParams(lp);
        camera.startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
    }

    @Override
    public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
    {
        // сохраняем полученные jpg в папке /sdcard/CameraExample/
        // имя файла - System.currentTimeMillis()

        try
        {
            File saveDir = new File("/sdcard/CameraExample/");

            if (!saveDir.exists())
            {
                saveDir.mkdirs();
            }

            FileOutputStream os = new
                    FileOutputStream(String.format("/sdcard/CameraExample/%d.jpg",
                    System.currentTimeMillis()));
            os.write(paramArrayOfByte);
            os.close();
        }
        catch (Exception e)
        {
        }

        // после того, как снимок сделан, показ превью отключается.необходимо включить его
        //paramCamera.startPreview();
    }

    @Override
    public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
    {
        if (paramBoolean)
        {
            // если удалось сфокусироваться, делаем снимок
            paramCamera.takePicture(null, null, null, this);
        }
    }

    @Override
    public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
    {
        // здесь можно обрабатывать изображение, показываемое в preview
    }
}
