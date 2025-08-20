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

public class Lessons extends JFrame {

    private int idlesson;
    private String name;
    private String description;
    private Object LesLessons;

    
    public Lessons(int idlesson, String name, String description) {
        this.idlesson = idlesson;
        this.name = name;
        this.description = description;
    }

    

    public int getIdLesson() {
        return idlesson;
    }

    public void setIdLesson(int idLesson) {
        this.idlesson = idlesson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    
    
    
    
    dbconnection dbcon = new dbconnection();
    public Lessons() {
        
        //JFrame
        setTitle("Lessons");
        setLocationRelativeTo(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        //main
        
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new  Object[3];
        
        columnsName[0] = "Idlesson";
        columnsName[1] = "Name";
        columnsName[2] = "Description";
        
        model.setColumnIdentifiers(columnsName);
        Object[] rowData = new Object[3];
        
        for(int i = 0; i < dbcon.getLessons().size(); i++){
           rowData[0] = dbcon.getLessons().get(i).getIdLesson(); 
           rowData[1] = dbcon.getLessons().get(i).getName(); 
           rowData[2] = dbcon.getLessons().get(i).getDescription(); 
           
           model.addRow(rowData);
        }
        
        table.setModel(model);
        System.out.println(dbcon.getLessons().size());
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JScrollPane pane = new JScrollPane(table);
        panel.add(pane,BorderLayout.CENTER);
        setContentPane(panel);
        
        
        
        

    }
    

}
