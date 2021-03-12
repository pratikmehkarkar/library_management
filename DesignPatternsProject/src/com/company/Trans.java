package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Trans extends JFrame{
    private JPanel panel1;
    private JTable table1;
    private JButton showtrans;
    //JDBC
    public String StrUrl="jdbc:mysql://localhost/library";
    public String StrUid="root";
    public String StrPwd= "root1234";

    public Trans()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String []{
                        "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
                }
        ));
        table1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        showtrans.setBackground(Color.darkGray);
        showtrans.setForeground(Color.BLUE);
        //jScrollPane1.setViewportView(jTable1);
        getContentPane().add(panel1);
        pack();
        setVisible(true);
        showtrans.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    //Main mc = new Main();
                    Connection connection;
                    connection= DriverManager.getConnection(StrUrl,StrUid,StrPwd);
                    ResultSet rs;
                    PreparedStatement stmt=connection.prepareStatement("SELECT book_name, book_author, price, tr_no, book_type from transactions");
                    rs = stmt.executeQuery();
                    table1.getColumnModel().getColumn(0).setHeaderValue("Book Name");
                    table1.getColumnModel().getColumn(1).setHeaderValue("Book Author");
                    table1.getColumnModel().getColumn(2).setHeaderValue("Book Price");
                    table1.getColumnModel().getColumn(3).setHeaderValue("Transaction No.");
                    table1.getColumnModel().getColumn(4).setHeaderValue("Book Category");
                    table1.getTableHeader().resizeAndRepaint();
                    table1.getTableHeader().setBackground(Color.WHITE);
                    table1.getTableHeader().setForeground(Color.BLACK);

                    // Removing Previous Data
                    while (table1.getRowCount() > 0) {
                        ((DefaultTableModel) table1.getModel()).removeRow(0);
                    }

                    int columns = rs.getMetaData().getColumnCount();
                    while (rs.next())
                    {
                        Object[] row = new Object[columns];
                        for (int i = 1; i <= columns; i++) {
                            row[i - 1] = rs.getObject(i); // 1
                        }
                        ((DefaultTableModel) table1.getModel()).insertRow(rs.getRow() - 1,row);
                    }
                    //return rt;
                }
                catch (Exception eee)
                {
                    System.err.println(eee);
                }
            }
        });
    }
}
