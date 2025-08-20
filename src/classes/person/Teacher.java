package classes.person;

import classes.database.dbconnection;
import classes.gui.menu;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Teacher extends Users {

    private String firstname;
    private String lastname;
    private String eidikotita;
    private String tilefono;

    //Constructors
    public Teacher(String firstname, String lastname, String eidikotita, String tilefono) {
        super();
        super.lastname = lastname;
        super.firstname = firstname;
        this.eidikotita = eidikotita;
        this.tilefono = tilefono;
    }

    //getters
   

    public String getEidikotita() {
        return eidikotita;
    }

    public String getTilefono() {
        return tilefono;
    }

    //setters
    

    public void setEidikotita(String eidikotita) {
        this.eidikotita = eidikotita;

    }

    public void setTilefono(String tilefono) {
        this.tilefono = tilefono;
    }

    dbconnection dbcon = new dbconnection();

    public Teacher() {

        //JFrame
        //main
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[4];

        columnsName[0] = "Firsname";
        columnsName[1] = "Lastname";
        columnsName[2] = "Eidikotita";
        columnsName[3] = "Tilefono";
        

        model.setColumnIdentifiers(columnsName);
        Object[] rowData = new Object[4];

        for (int i = 0; i < dbcon.getTeacher().size(); i++) {
            rowData[0] = dbcon.getTeacher().get(i).getFirstName();
            rowData[1] = dbcon.getTeacher().get(i).getLastName();
            rowData[2] = dbcon.getTeacher().get(i).getEidikotita();
            rowData[3] = dbcon.getTeacher().get(i).getTilefono();

            model.addRow(rowData);
        }

        JFrame frame = new JFrame();
        frame.setTitle("Teacher");
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        table.setModel(model);
        System.out.println(dbcon.getLessons().size());
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JScrollPane pane = new JScrollPane(table);
        panel.add(pane, BorderLayout.CENTER);
        frame.setContentPane(panel);

    }
}
