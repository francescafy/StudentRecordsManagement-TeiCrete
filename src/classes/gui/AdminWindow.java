package classes.gui;

import classes.database.dbconnection;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;

public class AdminWindow extends JFrame {

    JPanel p2, p3;
    JLabel tb4, tb5, tb6, tb7, tb8;
    JTextField tfn1, tfn2, tfn3, tfn4;
    JPasswordField pf1;
    JButton b2, b3, b4, b5;

    public AdminWindow() {

        setLayout(new BorderLayout());

        p2 = new JPanel(new GridLayout(5, 2));
        p3 = new JPanel(new GridLayout(1, 4));
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.NORTH);

        setVisible(true);
        setTitle("Admin");
        setSize(300, 200);

        tb4 = new JLabel("Usename: ");
        tb4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfn1 = new JTextField(10);

        tb5 = new JLabel("Password: ");
        tb5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pf1 = new JPasswordField();

        tb6 = new JLabel("Email: ");
        tb6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfn2 = new JTextField(10);

        tb7 = new JLabel("Lastname: ");
        tb7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfn3 = new JTextField(10);

        tb8 = new JLabel("Firstname: ");
        tb8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfn4 = new JTextField(10);

        b2 = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("inster.jpg"));
            b2.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b3 = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("update.png"));
            b3.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b4 = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("delete.png"));
            b4.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        b5 = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("clear.png"));
            b5.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        p2.add(tb4);
        p2.add(tfn1);
        p2.add(tb5);
        p2.add(pf1);
        p2.add(tb6);
        p2.add(tfn2);
        p2.add(tb7);
        p2.add(tfn3);
        p2.add(tb8);
        p2.add(tfn4);

        p3.add(b2);
        p3.add(b3);
        p3.add(b4);
        p3.add(b5);

        dbconnection dbcon = new dbconnection();

        //Insert
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    System.out.print("ok1");
                    String username = tfn1.getText().trim();
                    String password = pf1.getText().trim();
                    String email = tfn2.getText().trim();
                    String lname = tfn3.getText().trim();
                    String fname = tfn4.getText().trim();
                    boolean inserted = dbcon.doInsert(username, password, email, lname, fname);//h sunarthsh vrisketai sth dbconnection class 
                    //Message
                    if (inserted) {
                        JOptionPane.showMessageDialog(null, "Insert Ok");
                    } else {
                        JOptionPane.showMessageDialog(null, "Insert Failed,user exist", "Message", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {

                }
            }

        });

        //Update
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String username = tfn1.getText().trim();
                    String password = pf1.getText().trim();
                    String email = tfn2.getText().trim();
                    String lname = tfn3.getText().trim();
                    String fname = tfn4.getText().trim();
                    boolean updated = dbcon.doUpdate(username, password, email, lname, fname);//h sunarthsh vrisketai sth dbconnection class 
                    //Message
                    if (updated) {
                        JOptionPane.showMessageDialog(null, "Update Ok");
                    } else {
                        JOptionPane.showMessageDialog(null, "Update Failed,user non exist", "Message", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {

                }
            }

        });

        //Delete
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String username = tfn1.getText().trim();
                    String password = pf1.getText().trim();
                    String email = tfn2.getText().trim();
                    String lname = tfn3.getText().trim();
                    String fname = tfn4.getText().trim();
                    boolean deleted = dbcon.doDelete(username, password, email, lname, fname);//h sunarthsh vrisketai sth dbconnection class 
                    //Message
                    if (deleted) {
                        JOptionPane.showMessageDialog(null, "Delete Ok");
                    } else {
                        JOptionPane.showMessageDialog(null, "Delete Failed,user non exist", "Message", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {

                }
            }

        });

        //Clear
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tfn1.setText("");
                pf1.setText("");
                tfn2.setText("");
                tfn3.setText("");
                tfn4.setText("");
            }

        });

    }
}
