package com.example.densi.itmd455lab78;

/**
 * Created by densi on 4/4/2018.
 */

public class Book {

    private String bookName;
    private String bookAuthor;

    public Book()
    {

    }
    public Book(String name, String author)
    {
        super();
        this.bookName = name;
        this.bookAuthor = author;
    }

    public String getBookName()
    {
        return bookName;
    }
    public String getBookAuthor()
    {
        return bookAuthor;
    }
    public void setBookName(String name)
    {
        bookName = name;
    }
    public void setBookAuthor(String author)
    {
        bookAuthor = author;
    }
    public String toString()
    {
        return "Title: " + bookName + "\tAuthor: " + bookAuthor;
    }
}
