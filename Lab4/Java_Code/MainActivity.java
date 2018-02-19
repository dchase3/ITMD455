package com.example.densi.itmd455hw4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView bookList;
    String bookNames[] = {"Ender's Game", "Harry Potter", "Hobbit", "Lord of the Rings",
            "Maze Runner", "Star Trek", "Star Wars: Legends", "Star Wars: Bakura",
            "Star Wars: Thrawn", "The Underland Chronicles"};
    String bookCaption[] = {"'If you try and lose then it isn't your fault. But if you don't try and we lose, then it's all your fault'",
            "'Of course it is happening inside your head, Harry, but why on Earth should that mean it is not real?'",
            "'It does not do to leave a live dragon out of your calculations, if you live near him'",
            "'It's the job that's never started as takes longest to finish'",
            "'Just follow me and run like your life depends on it. Because it does'",
            "'I have been and always shall be your friend'",
            "'Without trust, there can be no genuine peace. neither in the politics, nor in the quiet individuality of the heart and spirit'",
            "'I would rather lay down my life for others' freedom than die quietly in slavery'",
            "'Anyone can make an error, Ensign. But that error doesn't become a mistake until you refuse to correct it'",
            "'Fly you high, Gregor the Overlander, fly you high!'"};
    int bookCovers[] = {R.drawable.eg, R.drawable.hp, R.drawable.hobbit, R.drawable.lotr,
            R.drawable.mr, R.drawable.st, R.drawable.legends, R.drawable.tab,
            R.drawable.thrawn, R.drawable.tuc};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookList = (ListView) findViewById(R.id.bookListView);
        CustomAdapter customadapter = new CustomAdapter(getApplicationContext(), bookNames, bookCaption, bookCovers);
        bookList.setAdapter(customadapter);
    }
}
