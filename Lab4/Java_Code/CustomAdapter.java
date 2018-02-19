package com.example.densi.itmd455hw4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    String bookNames[];
    String bookCaptions[];
    int bookCovers[];
    LayoutInflater inflater;

    public CustomAdapter(Context appcon, String[] bookNames, String[] bookCaptions, int[] bookCovers) {
        this.context = context;
        this.bookNames = bookNames;
        this.bookCaptions = bookCaptions;
        this.bookCovers = bookCovers;
        inflater = (LayoutInflater.from(appcon));
    }

    @Override
    public int getCount() {
        return bookNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_listview, null);
        TextView bookNamestv = (TextView) view.findViewById(R.id.textViewHead);
        TextView bookCaptionstv = (TextView) view.findViewById(R.id.textViewBody);
        ImageView bookCoveriv = (ImageView) view.findViewById(R.id.imageView);
        bookNamestv.setText(bookNames[i]);
        bookCaptionstv.setText(bookCaptions[i]);
        bookCoveriv.setImageResource(bookCovers[i]);
        return view;
    }
}
