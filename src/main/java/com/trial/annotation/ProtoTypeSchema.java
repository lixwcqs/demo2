package com.trial.annotation;

import java.util.ArrayList;

/**
 * Created by li on 2015/10/20.
 */
public class ProtoTypeSchema {

    public static void main(String[] args) {
        Book book = new Book();
        System.out.println("book: " + book);
        Book clone = book.clone();
        clone.getLists().add("李四");
        System.out.println(book.getLists().size());
        book.setBookName("JVM原理");
        System.out.println(clone.getBookName());
    }

}


class Book implements Cloneable{

    private String bookName;
    private ArrayList<String> lists;

    public Book() {
        System.out.println("Constructor");
        bookName = "设计模式之禅";
        lists = new ArrayList<String>();
        lists.add("张三");
    }

    public ArrayList<String> getLists() {
        return lists;
    }

    public void setLists(ArrayList<String> lists) {
        this.lists = lists;
    }

    @Override
    protected Book clone()  {
        Book book = null;
        try {
//            System.out.println("clone super: " + super.toString());
//            System.out.println("clone this: " + this.toString()+ (super.hashCode()==this.hashCode()));
            book = (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return book;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}