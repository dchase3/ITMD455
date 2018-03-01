package com.example.densi.itmd455hw6;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;
import android.widget.TextView;

public class BoundServer extends Service {
    private static String LOG_TAG = "BoundServer";
    private IBinder mBinder = new MyBinder();
    private Chronometer mChronometer;
    private boolean startStop = false;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(LOG_TAG, "in onCreate");
        mChronometer = new Chronometer(this);
        mChronometer.setBase(SystemClock.elapsedRealtime());
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v(LOG_TAG, "in onBind");
        return mBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.v(LOG_TAG, "in onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(LOG_TAG, "in onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(LOG_TAG, "in onDestroy");
        mChronometer.stop();
    }

    public String getTimestamp() {
        long elapsedMillis = SystemClock.elapsedRealtime()
                - mChronometer.getBase();
        int hours = (int) (elapsedMillis / 3600000);
        int minutes = (int) (elapsedMillis - hours * 3600000) / 60000;
        int seconds = (int) (elapsedMillis - hours * 3600000 - minutes * 60000) / 1000;
        int millis = (int) (elapsedMillis - hours * 3600000 - minutes * 60000 - seconds * 1000);
        return minutes + ":" + seconds + ":" + millis;
    }

    public void timer(final TextView timeText) {
        final Handler handle = new Handler();
        handle.post(new Runnable() {
            @Override
            public void run() {
                long elapsedMillis = SystemClock.elapsedRealtime()
                        - mChronometer.getBase();
                int hours = (int) (elapsedMillis / 3600000);
                int minutes = (int) (elapsedMillis - hours * 3600000) / 60000;
                int seconds = (int) (elapsedMillis - hours * 3600000 - minutes * 60000) / 1000;
                int millis = (int) (elapsedMillis - hours * 3600000 - minutes * 60000 - seconds * 1000);
                String time = minutes + ":" + seconds + ":" + millis;

                timeText.setText(time);
            }
        });
    }

    public void startTimer(){
        mChronometer.start();
        startStop = true;
    }

    public void stopTimer(){
        mChronometer.stop();
        startStop = false;
    }

    public void resetTimer(){
        mChronometer.setBase(SystemClock.elapsedRealtime());
        startStop = false;
    }

    public class MyBinder extends Binder {
        BoundServer getService() {
            return BoundServer.this;
        }
    }
}