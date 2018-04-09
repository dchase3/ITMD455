package com.example.densi.itmd455lab78;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ArrayList<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        SqlHelper db = new SqlHelper(this);
        Log.d("Name:", "Dennis Chase");

        db.addBook(new Book("Professional Android 4 Application Development", "Reto Meier"));
        db.addBook(new Book("Beginning Android 4 Application Development", "Wei- Meng Lee"));
        db.addBook(new Book("Programming Android", "Wallace Jackson"));
        db.addBook(new Book("Hello, Android", "Wallace Jackson"));

        List<Book> list = db.getAllBooks();
        int j = db.updateBook(list.get(0));
        db.deleteBook(list.get(0));
        db.getAllBooks();

        books = db.getAllBooks();

        CustomListAdapter cla = new CustomListAdapter(this, books);

        ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this, android.R.layout.simple_spinner_item, books);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = spinner.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, "New Selection", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
