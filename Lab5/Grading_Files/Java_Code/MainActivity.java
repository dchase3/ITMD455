package com.example.densi.itmd455hw5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.SeekBar;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView textSeek;
    Button startSlides;
    SeekBar seconds;
    int sec;
    DecimalFormat df = new DecimalFormat("#");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSeek = (TextView) findViewById(R.id.textViewSeconds);

        seconds = (SeekBar) findViewById(R.id.seekBar);
        seconds.setMin(1);
        seconds.setMax(21);
        seconds.setProgress(11);

        seconds.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                sec = i;
                textSeek.setText(df.format(sec));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        startSlides = (Button) findViewById(R.id.buttonMain);
        startSlides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DuelSlideShowActivity.class);
                intent.putExtra("seco", sec);
                startActivity(intent);
            }
        });

    }
}
