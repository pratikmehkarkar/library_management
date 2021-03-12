package com.company;

public class TextBook extends BookAbs{

    public TextBook(String bookType, String bookName, String author, int price) {

        setName(bookName);
        setAuthor(author);
        setPrice(price);
        setType(bookType);
    }


}
