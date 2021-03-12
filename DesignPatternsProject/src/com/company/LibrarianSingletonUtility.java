package com.company;

public class LibrarianSingletonUtility {

    private static LibrarianSingletonUtility instance;

    private BookFactoryIF bookFactory;

    private LibrarianSingletonUtility(){

        bookFactory = new BookFactory();
    }

    //this is the method which will return only one instance of singleton type
    public static LibrarianSingletonUtility getInstance(){

        if (instance == null) {
            instance = new LibrarianSingletonUtility();
        }
        return instance;
    }


    public BookFactoryIF getBookFactory() {
        return bookFactory;
    }
}
