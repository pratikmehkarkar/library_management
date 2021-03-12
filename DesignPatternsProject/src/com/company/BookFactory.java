package com.company;

public class BookFactory implements BookFactoryIF{

    BookIF book;

    @Override
    public BookIF createBook(String bookType, String bookName, String author, int price) {

        switch (bookType){
            case "textbook":
                book = new TextBook(bookType,bookName, author, price);
                break;

            case "journal":
                book = new Journal(bookType,bookName, author, price);
                break;

            case "magazine":
                book = new Magazine(bookType,bookName, author, price);
                break;

            default:
                System.out.println("Error please try again");
        }

        return book;
    }
}
