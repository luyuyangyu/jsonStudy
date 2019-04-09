package com.example.dell.jsonstudy;

public class Novel {

    private String bid;
    private String bookname;
    private String author_name;
    private String book_cover;
    private String class_name;
    private String stat_name;
    private String num_click;


    public String getBid() {
        return bid;
    }

    public String getBookname() {
        return bookname;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getBook_cover() {
        return book_cover;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getStat_name() {
        return stat_name;
    }

    public String getNum_click() {
        return num_click;
    }


    public void setBid(String bid) {
        this.bid = bid;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public void setBook_cover(String book_cover) {
        this.book_cover = book_cover;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public void setStat_name(String stat_name) {
        this.stat_name = stat_name;
    }

    public void setNum_click(String num_click) {
        this.num_click = num_click;
    }
}
