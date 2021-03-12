package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends javax.swing.JFrame
{
    private JTextField username;
    private JTextField password;
    private JButton loginButton;
    private JPanel loginpanel;
    public JFrame frame;

    public Login()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(loginpanel);
        pack();
        setVisible(true);
        loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String u_name = "admin";
                String u_pass = "admin";
                if(username.getText().equals(u_name) && password.getText().equals(u_pass))
                {
                    WelcomePage w = new WelcomePage();
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials !!");
                }
            }
        });
    }
    public static void main(String[] args)
    {
        Login l = new Login();
    }
}
