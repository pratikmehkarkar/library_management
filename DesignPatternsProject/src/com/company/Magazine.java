package com.company;

public class Magazine extends BookAbs {

    public Magazine(String bookType, String bookName, String author, int price)
    {

        setName(bookName);
        setAuthor(author);
        setPrice(price);
        setType(bookType);
    }


}
