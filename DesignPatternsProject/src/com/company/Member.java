package com.company;

public abstract class Member {

    private int memberID;
    private String type;
    private int noOfBooksIssued;
    private String name;
    private LibraryFacade libraryFacade;

    public LibraryFacade getLibraryFacade() {
        return libraryFacade;
    }

    public void setLibraryFacade(LibraryFacade libraryFacade) {
        this.libraryFacade = libraryFacade;
    }

    public void returnBook(BookIF book){
        libraryFacade.returnBook(book);
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNoOfBooksIssued() {
        return noOfBooksIssued;
    }

    public void setNoOfBooksIssued(int noOfBooksIssued) {
        this.noOfBooksIssued = noOfBooksIssued;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void requestBook(String bookType, String bookName) {

        String bookDetails = libraryFacade.requestBook(bookType, bookName);
        System.out.println(bookDetails);
    }

    public String afterCompletionOfBook()
    {

        String string = name+" has completed reading the book and";
        String a = string+" "+step1()+step2()+step3();
        step1();
        step2();
        step3();
        return a;
    }
    public abstract String step1();

    public abstract String step2();

    public abstract String step3();
}

