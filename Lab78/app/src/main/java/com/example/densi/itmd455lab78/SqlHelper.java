package com.example.densi.itmd455lab78;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by densi on 4/4/2018.
 */

public class SqlHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DataBaseBooks";
    private static final int DATABASE_VERSION = 16;
    public static final String DATABASE_TABLE = "books";

    private static final String TABLE_NAME = "bookName";
    private static final String TABLE_AUTHOR = "bookAuthor";

    public SqlHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE books ( bookName TEXT, bookAuthor TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS books");
        this.onCreate(sqLiteDatabase);
    }

    public void addBook(Book book)
    {
        Log.d("Added book:", book.toString());

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TABLE_NAME, book.getBookName());
        cv.put(TABLE_AUTHOR, book.getBookAuthor());

        sqLiteDatabase.insert(DATABASE_TABLE, null, cv);

        sqLiteDatabase.close();
    }

    public ArrayList<Book> getAllBooks()
    {
        ArrayList<Book> books = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cur = sqLiteDatabase.rawQuery("SELECT * FROM " + DATABASE_TABLE, null);

        Book b = null;
        if (cur.moveToFirst())
        {
            do
            {
                b = new Book();
                b.setBookName(cur.getString(0));
                b.setBookAuthor(cur.getString(1));
                books.add(b);
            }
            while (cur.moveToNext());
        }
        Log.d("Checking all books:", books.toString());
        return books;
    }

    public int updateBook(Book book)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TABLE_NAME, book.getBookName());
        cv.put(TABLE_AUTHOR, book.getBookAuthor());

        int i = sqLiteDatabase.update(DATABASE_TABLE, cv, TABLE_NAME + " = ?", new String[] {String.valueOf(book.getBookName())});

        sqLiteDatabase.close();
        Log.d("Updating book:", book.toString());
        return i;
    }

    public void deleteBook(Book book)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(DATABASE_TABLE, TABLE_NAME + " = ?", new String[] {String.valueOf(book.getBookName())});

        sqLiteDatabase.close();
        Log.d("Deleted book:", book.toString());
    }
}
