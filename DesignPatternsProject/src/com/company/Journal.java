package com.company;

public class Journal extends BookAbs {

    public Journal(String bookType, String bookName, String author, int price) {

        setName(bookName);
        setAuthor(author);
        setPrice(price);
        setType(bookType);

    }


}
