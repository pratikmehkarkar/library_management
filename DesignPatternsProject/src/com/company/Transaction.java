package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Transaction
{
    private int tranId;
    private int memberId;
    private String bookTitle;
    private Date dueDate;

    //Data is inserting into transaction database
    public Transaction(String bookName, String author, String bookType, int price)
    {
        try {
            Main mc = new Main();
            Connection connection;
            connection= DriverManager.getConnection(mc.StrUrl,mc.StrUid,mc.StrPwd);
            String sql = "INSERT INTO transactions (book_name, book_author, book_type, price) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, bookName);
            ps.setString(2,author);
            ps.setString(3,bookType);
            ps.setInt(4, price);
            ps.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void createTransaction()
    {

    }
}
