package com.company;

/*
Note:
1.main() method is present in Login class.
2.default username and password is "admin" & "admin"
* */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Main extends javax.swing.JFrame
{
    //JDBC Code Here
    public String StrUrl="jdbc:mysql://localhost/library";
    public String StrUid="root";
    public String StrPwd= "root1234";
    JRadioButton studentRadioButton;
    JRadioButton facultyRadioButton;
    JTextField txt_bookname;
    JTextField txt_author;
    JTextField txt_price;
    JButton returnBookButton;
    private JTextField txt_type;
    JTextField book_type_search;
    JTextField book_name_search;
    JButton searchBtn;
    JPanel mainpanel;
    String role;


    public Main()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainpanel);
        pack();
        setVisible(true);
        //this method will use to return a book to library
        returnBookButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                //radio button logic
                String stud_name = "Darren";
                String faculty_name = "Pratik";
                String book_name = "";
                String book_type = "";
                int book_price;
                String book_author = "";
                book_name = txt_bookname.getText();
                book_author = txt_author.getText();
                book_price = Integer.parseInt(txt_price.getText());
                book_type = txt_type.getText();

                //Facade DP
                LibrarianSingletonUtility librarianSingletonUtility = LibrarianSingletonUtility.getInstance();
                LibraryFacade libraryFacade = new LibraryFacade(librarianSingletonUtility);
                Student student1 = new Student(libraryFacade);
                student1.setName(stud_name);
                Faculty faculty1 = new Faculty(libraryFacade);
                faculty1.setName(faculty_name);
                if (studentRadioButton.isSelected())
                {
                    role = "Student";
                    BookIF book = libraryFacade.getLibrarianSingletonUtility().getBookFactory().createBook(book_type, book_name, book_author, book_price);
                    student1.returnBook(book);

                } else if (facultyRadioButton.isSelected()) {
                    role = "Faculty";
                    BookIF book = libraryFacade.getLibrarianSingletonUtility().getBookFactory().createBook(book_type, book_name, book_author, book_price);
                    faculty1.returnBook(book);
                } else {
                    role = "NO Button selected";
                }
                int x = libraryFacade.getBill().getPrice();
                System.out.println(x);
                JOptionPane.showMessageDialog(null, "Book "+book_name+" is returned by Library Member  "+stud_name+"\n"+ "Bill Amount: "+x);

            }
        });



        facultyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentRadioButton.setSelected(false);
            }
        });



        studentRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facultyRadioButton.setSelected(false);
            }
        });



        //Search Button will only search the book in our database if it is present or not
        searchBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String stud_name = "Darren";
                String faculty_name = "Pratik";
                LibrarianSingletonUtility librarianSingletonUtility = LibrarianSingletonUtility.getInstance();
                LibraryFacade libraryFacade = new LibraryFacade(librarianSingletonUtility);

                Student student1 = new Student(libraryFacade);
                student1.setName(stud_name);
                Faculty faculty1 = new Faculty(libraryFacade);
                faculty1.setName(faculty_name);

                String search_bookType = "";
                search_bookType = book_type_search.getText();
                String search_bookName = "";
                search_bookName = book_name_search.getText();
                student1.requestBook(search_bookType,search_bookName);

                JOptionPane.showMessageDialog(null, "Our Records shows Book "
                        +search_bookName+" is available in Library !"+"\n"+student1.afterCompletionOfBook());

            }
        });
    }
}

