package classes.gui;

import classes.database.dbconnection; //importing dbconnection package for creating dbconnection objects
import classes.person.Lessons;
import classes.person.Teacher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.naming.spi.DirStateFactory;

public final class menu {

    // DB connection
    dbconnection dbcon = new dbconnection();

    private JPanel p;

    JFrame f = new JFrame("Ηλεκτρονικη γραμματεια τει κρητης");
    JFrame f3 = new JFrame("Registration");
    JFrame f4 = new JFrame("Contact");

    public menu() throws IOException {
        gui();
    }

    public void gui() throws IOException {

        //IMAGE
        BufferedImage wPic = ImageIO.read(this.getClass().getResource("tei.jpg"));
        JLabel wIcon = new JLabel(new ImageIcon(wPic));

        //Frames - Panel
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1024, 400);
        f.setVisible(true);

        p = new JPanel();

        p.add(wIcon);
        f.add(p);
        f.setVisible(true);

        // Start MENUBAR-------------------------------------------------------
        JMenuBar mb = new JMenuBar();

        //Item users
        JMenu users = new JMenu("Users");
        mb.add(users);

        BufferedImage loginIcon = ImageIO.read(this.getClass().getResource("login.png"));
        JMenuItem login = new JMenuItem("Login", new ImageIcon(loginIcon));
        users.add(login);

        //ActionListener Login
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LoginWindow l1 = new LoginWindow();
            }
        });

        //Item Admin
        BufferedImage adminIcon = ImageIO.read(this.getClass().getResource("admin.png"));
        JMenuItem admin = new JMenuItem("Admin", new ImageIcon(adminIcon));
        users.add(admin);

        //ActionListener Admin
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AdminWindow l2 = new AdminWindow();
            }
        });

        //Item Exit
        BufferedImage exitIcon = ImageIO.read(this.getClass().getResource("exit.png"));
        JMenuItem exit = new JMenuItem("Exit", new ImageIcon(exitIcon));
        users.add(exit);

        //ActionListener Exit
        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        //Item Department
        JMenu dep = new JMenu("Department");
        mb.add(dep);
        JMenuItem les = new JMenuItem("Lessons");
        dep.add(les);
        JMenuItem tea= new JMenuItem("Teaches");
        dep.add(tea);
        
        les.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("ok");
                Lessons l = new Lessons();
            }
        });
        
        tea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("ok");
                Teacher t = new Teacher();
            }
        });

        //Item Contact
        JMenu con = new JMenu("Contact");
        mb.add(con);

        JMenuItem mes = new JMenuItem("Message");
        con.add(mes);
        
        //ActionListener Message
        mes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MessageContact l3 = new MessageContact();
            }
        });
       

        f.setJMenuBar(mb);

        // End MENUBAR--------------------------------------------------------
    }
}
