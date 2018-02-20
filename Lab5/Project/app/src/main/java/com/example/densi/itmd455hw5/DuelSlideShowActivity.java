package com.example.densi.itmd455hw5;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;

public class DuelSlideShowActivity extends AppCompatActivity {

    Handler hand = new Handler();

    Runnable runn = new Runnable(){
        public void run(){

            int seconds = getIntent().getIntExtra("seco", 1);

            firstTextView.setText(firstText[i]);
            firstTextView.setTextColor(Color.parseColor(firstColor[i]));
            lastTextView.setText(lastText[i]);
            lastTextView.setTextColor(Color.parseColor(lastColor[i]));
            if(i==0)
            {
                iv[10].setVisibility(View.INVISIBLE);
                iv[i].setVisibility(View.VISIBLE);
            }
            else
            {
                iv[i-1].setVisibility(View.INVISIBLE);
                iv[i].setVisibility(View.VISIBLE);
            }

            if(i==10)
            {
                i = 0;
            }
            else
            {
                i++;
            }
            hand.postDelayed(this, (seconds * 1000));
        }
    };

    TextView firstTextView, lastTextView;
    ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11;
    ImageView[] iv = {iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11};
    Button endSlides;
    int i = 0;
    Intent intent = getIntent();

    String firstText[] = {"Obi-Wan Kenobi", "Anakin Skywalker", "Yoda",
            "Anakin Skywalker", "Obi-Wan Kenobi", "Mace Windu", "Yoda",
            "Anakin Skywalker", "Ben Kenobi", "Luke Skywalker", "Luke Skywalker"};
    String lastText[] = {"Darth Maul", "Count Dooku", "Count Dooku",
            "Count Dooku", "General Grevious", "Darth Sidious", "Darth Sidious",
            "Obi-Wan Kenobi", "Darth Vader", "Darth Vader", "Darth Vader"};
    String firstColor[] = {"#001eff","#001eff","#04ff00","#001eff","#001eff",
            "#b300ff","#04ff00","#001eff","#001eff","#001eff","#04ff00"};
    String lastColor[] = {"#e70c00", "#e70c00", "#e70c00", "#e70c00", "#04ff00",
            "#e70c00", "#e70c00", "#001eff", "#e70c00", "#e70c00", "#e70c00"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duel_slide_show);

        firstTextView = (TextView) findViewById(R.id.textViewFirst);
        lastTextView = (TextView) findViewById(R.id.textViewLast);

        iv1 = (ImageView) findViewById(R.id.imageView1);
        iv2 = (ImageView) findViewById(R.id.imageView2);
        iv3 = (ImageView) findViewById(R.id.imageView3);
        iv4 = (ImageView) findViewById(R.id.imageView4);
        iv5 = (ImageView) findViewById(R.id.imageView5);
        iv6 = (ImageView) findViewById(R.id.imageView6);
        iv7 = (ImageView) findViewById(R.id.imageView7);
        iv8 = (ImageView) findViewById(R.id.imageView8);
        iv9 = (ImageView) findViewById(R.id.imageView9);
        iv10 = (ImageView) findViewById(R.id.imageView10);
        iv11 = (ImageView) findViewById(R.id.imageView11);

        iv[0] = iv1;
        iv[1] = iv2;
        iv[2] = iv3;
        iv[3] = iv4;
        iv[4] = iv5;
        iv[5] = iv6;
        iv[6] = iv7;
        iv[7] = iv8;
        iv[8] = iv9;
        iv[9] = iv10;
        iv[10] = iv11;

        runn.run();

        endSlides = (Button) findViewById(R.id.buttonBack);
        endSlides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
