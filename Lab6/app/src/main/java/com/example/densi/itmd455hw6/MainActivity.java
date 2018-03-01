package com.example.densi.itmd455hw6;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.densi.itmd455hw6.BoundServer;

public class MainActivity extends AppCompatActivity {
    BoundServer mBoundService;
    boolean mServiceBound = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView timestampText = (TextView) findViewById(R.id.textView);
        Button startButton = (Button) findViewById(R.id.startButton);
        Button stopButton = (Button) findViewById(R.id.stopButton);
        Button resetButton = (Button) findViewById(R.id.resetButton);
        Button stopServiceButton = (Button) findViewById(R.id.stopSButton);
        Button startServiceButton = (Button) findViewById(R.id.startSButton);

        startButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mBoundService.startTimer();
                mBoundService.timer(timestampText);
            }
        });

        stopButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mBoundService.stopTimer();
            }
        });

        resetButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mBoundService.resetTimer();
            }
        });

        startServiceButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onStart();
            }
        });

        stopServiceButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mServiceBound) {
                    unbindService(mServiceConnection);
                    mServiceBound = false;
                }
                Intent intent = new Intent(MainActivity.this,
                        BoundServer.class);
                stopService(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, BoundServer.class);
        startService(intent);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundServer.MyBinder myBinder = (BoundServer.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }
    };
}