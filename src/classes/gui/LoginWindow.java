package classes.gui;

import classes.database.dbconnection;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginWindow extends JFrame {

    JPanel p1, p4;
    JLabel tb1, tb2;
    JTextField tfn;
    JPasswordField pf;
    JButton b1;

    public LoginWindow() {
        setLayout(new BorderLayout());
        p1 = new JPanel(new GridLayout(2,2));
        p4 = new JPanel(new GridLayout(1,2));
        add(p1, BorderLayout.CENTER);
        add(p4, BorderLayout.SOUTH);
        
        setVisible(true);
        setTitle("Login");
        setSize(250,150);

        tb1 = new JLabel("Usename: ");
        tb1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfn = new JTextField(10);
        
        tb2 = new JLabel("Password: ");
        tb2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pf = new JPasswordField();
        
        b1 = new JButton("Log in");

        p1.add(tb1);
        p1.add(tfn);
        p1.add(tb2);
        p1.add(pf);

        p4.add(b1);
        dbconnection dbcon = new dbconnection();
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    System.out.println("ok");
                    String user = tfn.getText().trim();
                    String pass = pf.getText().trim();
                    System.out.println(user + pass);
                    boolean login = dbcon.doLogin(user, pass); //h sunarthsh vrisketai sth dbconnection class
                    
                    if (login) {
                        JOptionPane.showMessageDialog(null, "Wellcome");
                    } else {
                        JOptionPane.showMessageDialog(null, "Login failed,user non exist", "Message", JOptionPane.ERROR_MESSAGE);
                    }
                  

                } catch (Exception ex) {
                }
            }
        });
        
        
    }

    
}
