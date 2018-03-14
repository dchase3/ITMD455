//Testing
//Trollololol
package com.example.densi.itmd455hw3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.SeekBar;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView celsius, fahrenheit, tcold, tright, thot;
    ImageView icold, iright, ihot;
    SeekBar seek;
    double fah, cel;
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celsius = (TextView) findViewById(R.id.celTemp);
        fahrenheit = (TextView) findViewById(R.id.fahTemp);
        tcold = (TextView) findViewById(R.id.tooCold);
        tright = (TextView) findViewById(R.id.justRight);
        thot = (TextView) findViewById(R.id.tooHot);

        icold = (ImageView) findViewById(R.id.imageCold);
        iright = (ImageView) findViewById(R.id.imageRight);
        ihot = (ImageView) findViewById(R.id.imageHot);

        seek = (SeekBar) findViewById(R.id.seekBar);
        seek.setMax(200);
        seek.setProgress(100);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                fah = i;
                cel = (5.0/9.0)*(fah-32);
                celsius.setText(df.format(cel));
                fahrenheit.setText(df.format(fah));

                if(fah<=40)
                {
                    tcold.setVisibility(View.VISIBLE);
                    tright.setVisibility(View.INVISIBLE);
                    thot.setVisibility(View.INVISIBLE);
                    icold.setVisibility(View.VISIBLE);
                    iright.setVisibility(View.INVISIBLE);
                    ihot.setVisibility(View.INVISIBLE);
                }
                else if((fah>40)&&(fah<90))
                {
                    tcold.setVisibility(View.INVISIBLE);
                    tright.setVisibility(View.VISIBLE);
                    thot.setVisibility(View.INVISIBLE);
                    icold.setVisibility(View.INVISIBLE);
                    iright.setVisibility(View.VISIBLE);
                    ihot.setVisibility(View.INVISIBLE);
                }
                else
                {
                    tcold.setVisibility(View.INVISIBLE);
                    tright.setVisibility(View.INVISIBLE);
                    thot.setVisibility(View.VISIBLE);
                    icold.setVisibility(View.INVISIBLE);
                    iright.setVisibility(View.INVISIBLE);
                    ihot.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
