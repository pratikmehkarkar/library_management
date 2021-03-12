package com.company;

import java.sql.*;

public class LibraryFacade {

    private BookIF book;
    private Transaction transaction;
    private Bill bill;
    private BookFactoryIF bookFactory;
    private LibrarianSingletonUtility librarianSingletonUtility;


    public LibraryFacade(LibrarianSingletonUtility librarianSingletonUtility)
    {
        this.librarianSingletonUtility = librarianSingletonUtility;
        this.bookFactory = this.librarianSingletonUtility.getBookFactory();
    }

    public String requestBook(String bookType, String bookName)
    {
        String rt = "";
        switch (bookType)
        {
            case "textbook":
                //for textbook
                try
                {
                    Main mc = new Main();
                    Connection connection;
                    connection=DriverManager.getConnection(mc.StrUrl,mc.StrUid,mc.StrPwd);
                    ResultSet rs;
                    PreparedStatement stmt=connection.prepareStatement("select book_name, author, category, price from textbook where category = ? and book_name = ?");
                    stmt.setString(1,bookType);
                    stmt.setString(2, bookName);
                    rs = stmt.executeQuery();
                    rs.next();
                    String a = rs.getString("book_name");
                    //rs.next();
                    String b = rs.getString("author");
                    //rs.next();
                    String c = rs.getString("category");
                    //rs.next();
                    int d = rs.getInt("price");
                    //rs.next();
                    System.out.println(a + "" + "" +b+ "" +c+ "" +d);
                    rt = a+" "+b+ " "+c+ " "+d;
                    book = librarianSingletonUtility.getBookFactory().createBook(c,a,b,d);
                    System.out.println(d);
                    //return rt;

                }
                catch (Exception e)
                {
                    System.err.println(e);
                }
                break;

            case "journal":
                try
                {
                    Main mc = new Main();
                    Connection connection;
                    connection=DriverManager.getConnection(mc.StrUrl,mc.StrUid,mc.StrPwd);
                    ResultSet rs;
                    PreparedStatement stmt=connection.prepareStatement("select book_name, author, category, price from journal where category = ? and book_name = ?");
                    stmt.setString(1,bookType);
                    stmt.setString(2, bookName);
                    rs = stmt.executeQuery();
                    rs.next();
                    String a = rs.getString("book_name");
                    //rs.next();
                    String b = rs.getString("author");
                    //rs.next();
                    String c = rs.getString("category");
                    //rs.next();
                    int d = rs.getInt("price");
                    rs.next();
                    System.out.println(a + "" + "" +b+ "" +c+ "" +d);
                    rt = a+" "+b+ " "+c+ " "+d;
                    book = librarianSingletonUtility.getBookFactory().createBook(c,a,b,d);

                    //return rt;
                }
                catch (Exception e)
                {
                    System.err.println(e);
                }
                break;

            case "magazine":
                try
                {
                    Main mc = new Main();
                    Connection connection;
                    connection=DriverManager.getConnection(mc.StrUrl,mc.StrUid,mc.StrPwd);
                    ResultSet rs;
                    PreparedStatement stmt=connection.prepareStatement("select book_name, author, category, price from magazine where category = ? and book_name = ?");
                    stmt.setString(1,bookType);
                    stmt.setString(2, bookName);
                    rs = stmt.executeQuery();
                    rs.next();
                    String a = rs.getString("book_name");
                    //rs.next();
                    String b = rs.getString("author");
                    //rs.next();
                    String c = rs.getString("category");
                    //rs.next();
                    int d = rs.getInt("price");
                    rs.next();
                    System.out.println(a + "" + "" +b+ "" +c+ "" +d);
                    rt = a+" "+b+ " "+c+ " "+d;
                    book = librarianSingletonUtility.getBookFactory().createBook(c,a,b,d);
                }
                catch (Exception e)
                {
                    System.err.println(e);
                }
                break;

            default:
                System.out.println("Error please try again");
        }

        return rt;
    }

    public void returnBook(BookIF book)
    {
        try {
            transaction = new Transaction(book.getName(),book.getAuthor(),book.getType(),book.getPrice());
            bill = new Bill(book.getPrice());
            System.out.println(bill.getPrice());
            System.out.println("Data Inserted");
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }

    public LibrarianSingletonUtility getLibrarianSingletonUtility() {
        return librarianSingletonUtility;
    }

    public void setLibrarianSingletonUtility(LibrarianSingletonUtility librarianSingletonUtility) {
        this.librarianSingletonUtility = librarianSingletonUtility;
    }

    public BookFactoryIF getBookFactory() {
        return bookFactory;
    }

    public void setBookFactory(BookFactoryIF bookFactory) {
        this.bookFactory = bookFactory;
    }

    public BookIF getBook() {
        return book;
    }

    public void setBook(BookIF book) {
        this.book = book;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}

