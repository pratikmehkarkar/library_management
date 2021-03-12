package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame
{
    private JPanel welcomepanel;
    private JButton addNewBookButton;
    private JButton returnBookSearchBookButton;
    private JLabel label;
    private JButton viewBookTransactionsButton;

    public WelcomePage()
    {
        //label = new JLabel(new ImageIcon("lib.gif"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setSize(200,200);
        getContentPane().add(welcomepanel);
        pack();
        setVisible(true);

        addNewBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                AddBookOnly a = new AddBookOnly();
            }
        });

        returnBookSearchBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Main m = new Main();
            }
        });
        viewBookTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Trans t = new Trans();
            }
        });
    }

    /*public static void main(String[] args)
    {
        WelcomePage w = new WelcomePage();
    }*/
}
