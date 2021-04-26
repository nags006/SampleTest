package com.spidy.sampletest.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.spidy.sampletest.R;
import com.spidy.sampletest.util.WaveDrawable;


public class C9354S extends AppCompatActivity
{
 private ImageView imageView;
 Handler handler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = (ImageView)findViewById(R.id.imghrt);
        try
        {
            WaveDrawable chromeWave = new WaveDrawable(this, R.drawable.heart);
            chromeWave.setIndeterminate(true);
            imageView.setImageDrawable(chromeWave);
            handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(C9354S.this, OtpActivty.class);
                    startActivity(intent);
                    finish();
                }
            },3000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Intent intent=new Intent(C9354S.this, OtpActivty.class);
            startActivity(intent);
            finish();

        }
    }

}
