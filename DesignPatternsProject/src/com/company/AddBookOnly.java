package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AddBookOnly extends JFrame
{
    private JTextField b_name;
    private JTextField b_author;
    private JTextField b_price;
    private JTextField b_cat;
    private JButton Save;
    private JPanel addpanel;
    //JDBC connection
    public String StrUrl="jdbc:mysql://localhost/library";
    public String StrUid="root";
    public String StrPwd= "root1234";

    public AddBookOnly()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,600,600,600);
        add(addpanel);
        pack();
        setVisible(true);
        Save.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = b_name.getText();
                String author = b_author.getText();
                String price = b_price.getText();
                String cat = b_cat.getText();
                if (cat.equals("textbook"))
                {
                    try
                    {
                        Connection connection;
                        //Statement stmt;
                        connection= DriverManager.getConnection(StrUrl,StrUid,StrPwd);
                        String sql = "INSERT INTO textbook (book_name, author, category, price) VALUES (?,?,?,?)";
                        PreparedStatement ps = connection.prepareStatement(sql);
                        ps.setString(1,name);
                        ps.setString(2, author);
                        ps.setString(3, cat);
                        ps.setString(4,price);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Records Added Successfully !");
                    }
                    catch (Exception ee)
                    {
                        System.err.println(e);
                    }
                }
                else if(cat.equals("journal"))
                {
                    try
                    {
                        //Main mc = new Main();
                        Connection connection;
                        //Statement stmt;
                        connection= DriverManager.getConnection(StrUrl,StrUid,StrPwd);
                        String sql = "INSERT INTO journal (book_name, author, category, price) VALUES (?,?,?,?)";
                        PreparedStatement ps = connection.prepareStatement(sql);
                        ps.setString(1,name);
                        ps.setString(2, author);
                        ps.setString(3, cat);
                        ps.setString(4,price);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Records Added Successfully !");
                    }
                    catch (Exception ee)
                    {
                        System.err.println(e);
                    }
                }
                else if(cat.equals("magazine"))
                {
                    try
                    {
                        Main mc = new Main();
                        Connection connection;
                        //Statement stmt;
                        connection= DriverManager.getConnection(mc.StrUrl,mc.StrUid,mc.StrPwd);
                        String sql = "INSERT INTO magazine (book_name, author, category, price) VALUES (?,?,?,?)";
                        PreparedStatement ps = connection.prepareStatement(sql);
                        ps.setString(1,name);
                        ps.setString(2, author);
                        ps.setString(3, cat);
                        ps.setString(4,price);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Book Records Added Successfully !");
                    }
                    catch (Exception ee)
                    {
                        System.err.println(e);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Try Again !");
                }
            }
        });

    }
}
