package com.example.densi.itmd455lab78;

import java.util.List;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SqlHelper db = new SqlHelper(this);
        db.addBook(new Book("Professional Android 4 Application Development", "Reto Meier"));
        db.addBook(new Book("Beginning Android 4 Application Development", "Wei- Meng Lee"));
        db.addBook(new Book("Programming Android", "Wallace Jackson"));
        db.addBook(new Book("Hello, Android", "Wallace Jackson"));

        List<Book> list = db.getAllBooks();
        int j = db.updateBook(list.get(0));
        db.deleteBook(list.get(0));
        db.getAllBooks();
    }
}
