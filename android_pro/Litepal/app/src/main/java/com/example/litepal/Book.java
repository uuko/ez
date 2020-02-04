package com.example.litepal;

import org.litepal.crud.LitePalSupport;

public class Book extends LitePalSupport {
    private  int id;
    private  String author;
    private  double price;
    private  int pages;
    private  String name;
    public  int getId(){
        return id;
    }
    public  int  setId(){
        return id;
    }
    public  String getAuthor(){
        return author;
    }
    public void setAuthor(){
        this.author=author;
    }

    public  void  setPages(){
        this.pages=pages;
    }
    public int getPages(){
        return pages;
    }
    public void  setName(){
        this.name=name;
    }
    public  String getName(){
        return name;
    }

}
