# ITMD 455 Lab 5

This repository has a quick access to all files that were actually used to make the Android App.

<!-- TOC depthFrom:1 depthTo:2 withLinks:1 updateOnSave:1 orderedList:0 -->

- [Screenshots](#screenshots)
- [Java Code](#java-code)
  - [MainActivity](#mainactivity.java)
  - [DuelSlideShowActivity](#duelslideshowactivity.java)
- [XML Code](#xml-code)
  - [AndroidManifest](#androidmanifest.xml)
  - [activity_main](#activity_main.xml)
  - [duel_slide_show](#duel_slide_show.xml)


<!-- /TOC -->

## Screenshots
![Screenshot1](ITMD455/Lab5/Grading_Files/screenshots/Capture1.PNG)
![Screenshot2](/screenshots/Capture2.png)
![Screenshot3](/screenshots/Capture3.png)
![Screenshot4](/screenshots/Capture4.png)
![Screenshot5](/screenshots/Capture5.png)
![Screenshot6](/screenshots/Capture6.png)

## Java Code

### MainActivity.java
```java
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
```

### DuelSlideShowActivity.java
```java
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
```

## XML Code

### AndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.densi.itmd455hw5">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".DuelSlideShowActivity"> </activity>
    </application>

</manifest>
```

### activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#000"
    tools:context="com.example.densi.itmd455hw5.MainActivity">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="295dp"
        android:layout_height="227dp"
        android:layout_marginEnd="44dp"
        android:layout_marginStart="45dp"
        android:layout_marginTop="16dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/starwars" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="138dp"
        android:layout_marginStart="139dp"
        android:text="Duels Slide Show"
        android:textAllCaps="false"
        android:textColor="#ffbf00"
        android:textSize="18sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView" />

    <SeekBar
        android:id="@+id/seekBar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />

    <TextView
        android:id="@+id/textViewSeconds"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="155dp"
        android:layout_marginStart="155dp"
        android:layout_marginTop="16dp"
        android:text="0"
        android:textColor="#ffbf00"
        android:textSize="18sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/seekBar" />

    <Button
        android:id="@+id/buttonMain"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="148dp"
        android:layout_marginStart="148dp"
        android:layout_marginTop="16dp"
        android:padding="8dp"
        android:text="Start Slide Show"
        android:textColor="#000"
        android:background="#d1ffbf00"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textViewSeconds" />
</android.support.constraint.ConstraintLayout>
```

### duel_slide_show.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#000">

    <TextView
        android:id="@+id/textViewVS"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="164dp"
        android:layout_marginStart="162dp"
        android:layout_marginTop="48dp"
        android:text="VS."
        android:textColor="#ffe100"
        android:textSize="24sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textViewFirst"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="16dp"
        android:text="Good"
        android:textColor="#fff"
        android:textSize="18sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="@id/textViewVS"
        app:layout_constraintEnd_toStartOf="@+id/textViewVS" />

    <TextView
        android:id="@+id/textViewLast"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:text="Evil"
        android:textColor="#fff"
        android:textSize="18sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="@id/textViewVS"
        app:layout_constraintStart_toEndOf="@+id/textViewVS" />

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="283dp"
        android:layout_height="302dp"
        android:layout_marginEnd="16dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="8dp"
        android:visibility="invisible"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textViewVS"
        app:srcCompat="@drawable/ep1" />

    <Button
        android:id="@+id/buttonBack"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="149dp"
        android:layout_marginStart="147dp"
        android:layout_marginTop="8dp"
        android:background="#ffe100"
        android:textColor="#000"
        android:text="Button"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView1" />

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="295dp"
        android:layout_height="304dp"
        android:layout_marginEnd="44dp"
        android:layout_marginStart="45dp"
        android:layout_marginTop="8dp"
        android:visibility="invisible"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textViewVS"
        app:srcCompat="@drawable/ep2v1" />

    <ImageView
        android:id="@+id/imageView3"
        android:layout_width="294dp"
        android:layout_height="298dp"
        android:layout_marginEnd="45dp"
        android:layout_marginStart="45dp"
        android:visibility="invisible"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@+id/imageView2"
        app:srcCompat="@drawable/ep2v2" />

    <ImageView
        android:id="@+id/imageView4"
        android:layout_width="295dp"
        android:layout_height="297dp"
        android:layout_marginEnd="41dp"
        android:layout_marginStart="38dp"
        android:visibility="invisible"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.7"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@+id/imageView3"
        app:srcCompat="@drawable/ep3v1" />

    <ImageView
        android:id="@+id/imageView5"
        android:layout_width="295dp"
        android:layout_height="308dp"
        android:layout_marginEnd="44dp"
        android:layout_marginStart="45dp"
        android:layout_marginTop="8dp"
        android:visibility="invisible"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textViewVS"
        app:srcCompat="@drawable/ep3v2" />

    <ImageView
        android:id="@+id/imageView6"
        android:layout_width="298dp"
        android:layout_height="324dp"
        android:layout_marginEnd="42dp"
        android:layout_marginStart="44dp"
        android:layout_marginTop="8dp"
        android:visibility="invisible"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textViewVS"
        app:srcCompat="@drawable/ep3v3" />

    <ImageView
        android:id="@+id/imageView7"
        android:layout_width="300dp"
        android:layout_height="278dp"
        android:layout_marginEnd="41dp"
        android:layout_marginStart="43dp"
        android:layout_marginTop="8dp"
        android:visibility="invisible"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textViewVS"
        app:srcCompat="@drawable/ep3v4" />

    <ImageView
        android:id="@+id/imageView8"
        android:layout_width="302dp"
        android:layout_height="289dp"
        android:layout_marginEnd="39dp"
        android:layout_marginStart="43dp"
        android:layout_marginTop="8dp"
        android:visibility="invisible"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textViewVS"
        app:srcCompat="@drawable/ep3v5" />

    <ImageView
        android:id="@+id/imageView9"
        android:layout_width="312dp"
        android:layout_height="340dp"
        android:layout_marginEnd="34dp"
        android:layout_marginStart="38dp"
        android:layout_marginTop="8dp"
        android:visibility="invisible"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textViewVS"
        app:srcCompat="@drawable/ep4" />

    <ImageView
        android:id="@+id/imageView10"
        android:layout_width="321dp"
        android:layout_height="350dp"
        android:layout_marginEnd="29dp"
        android:layout_marginStart="34dp"
        android:layout_marginTop="8dp"
        android:visibility="invisible"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textViewVS"
        app:srcCompat="@drawable/ep5" />

    <ImageView
        android:id="@+id/imageView11"
        android:layout_width="329dp"
        android:layout_height="359dp"
        android:layout_marginEnd="26dp"
        android:layout_marginStart="29dp"
        android:layout_marginTop="8dp"
        android:visibility="invisible"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textViewVS"
        app:srcCompat="@drawable/ep6" />
</android.support.constraint.ConstraintLayout>
```