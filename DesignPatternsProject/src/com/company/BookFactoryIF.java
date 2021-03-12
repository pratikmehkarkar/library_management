package com.company;

public interface BookFactoryIF {

    BookIF createBook(String bookType, String bookName, String author, int price);


}
