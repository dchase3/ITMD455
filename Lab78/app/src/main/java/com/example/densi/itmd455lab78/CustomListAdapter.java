package com.example.densi.itmd455lab78;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by densi on 4/9/2018.
 */

public class CustomListAdapter extends ArrayAdapter<String>
{
    private final Activity context;
    private ArrayList<Book> books = new ArrayList<Book>();

    public CustomListAdapter(Activity context, ArrayList<Book> books)
    {
        super (context, R.layout.books_list);
        this.context = context;
        this.books = books;
    }
}
