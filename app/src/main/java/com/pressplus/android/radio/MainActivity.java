package com.pressplus.android.radio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.pits.library.radio.RadioListener;
import com.pits.library.radio.RadioManager;


public class MainActivity extends AppCompatActivity implements RadioListener {

    private RadioManager mRadioManager;
    private AppCompatButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button = (AppCompatButton) findViewById(R.id.button);
        mRadioManager = RadioManager.with(this, MainActivity.class);
        mRadioManager.registerListener(this);
        mRadioManager.setLogging(true);
        mRadioManager.connect();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mRadioManager.isPlaying()) {
                    mRadioManager.startRadio("http://s1.voscast.com:8418");
                }
                else {
                    mRadioManager.stopRadio();
                }

            }
        });
    }

    @Override
    public void onRadioLoading() {
        Log.i("TAG", "Loading");

    }

    @Override
    public void onRadioConnected() {
        System.out.println("OK");
        Log.i("TAG", "connected");
    }

    @Override
    public void onRadioStarted() {
        Log.i("TAG", "started");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.setText("Stop");
            }
        });

    }

    @Override
    public void onRadioStopped() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.setText("play");
            }
        });

    }

    @Override
    public void onMetaDataReceived(String s, String s1) {
        Log.i("s", " "+ s);
        Log.i("s1", " "+s1);

    }

    @Override
    public void onError() {

    }

    @Override
    public void songInfo(final String title) {

    }
}
