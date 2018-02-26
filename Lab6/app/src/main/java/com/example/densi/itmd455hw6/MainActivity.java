package com.example.densi.itmd455hw6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BoundServer bServer;
    boolean bBound = false;

    Button startSButton = (Button) findViewById(R.id.startSButton);
    Button stopSButton = (Button) findViewById(R.id.stopSButton);
    Button startButton = (Button) findViewById(R.id.startButton);
    Button stopButton = (Button) findViewById(R.id.stopButton);
    Button resetButton = (Button) findViewById(R.id.resetButton);

    TextView text = (TextView) findViewById(R.id.textView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!bBound)
                {
                    onStart();
                    text.setText("Start");
                }
            }
        });//Start Services

        stopSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bBound)
                {
                    onStop();
                    text.setText("Stop");
                }
            }
        });//Stop Services

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });//Start

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });//Stop

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });//Reset
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, BoundServer.class);
        bindService(intent, bConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(bConnection);
        bBound = false;
    }

    private ServiceConnection bConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BoundServer.LBinder binder = (BoundServer.LBinder) iBinder;
            bServer = binder.getService();
            bBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            bBound = false;
        }
    };
}
