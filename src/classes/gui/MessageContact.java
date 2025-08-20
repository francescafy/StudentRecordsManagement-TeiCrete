package classes.gui;

import java.awt.*;
import javax.swing.*;

public class MessageContact extends JFrame {

  
    JPanel pm;
    JTextArea l1;

    public MessageContact() {
        setLayout(new BorderLayout());

        pm = new JPanel(new GridLayout());
        add(pm, BorderLayout.CENTER);

        l1 = new JTextArea("Γραμματεία \n"
                + "Τμήμα Μηχανικών Πληροφορικής, ΣΤΕΦ, ΤΕΙ Κρήτης, Ηράκλειο, Κρήτη 71500 \n"
                + "Τηλ: 2810-379716, 2810-379795, 2810-379853\n"
                + "Fax: 2810-379717\n"
                + "E-mail: secretariat@ie.teicrete.gr\n"
                + "Website: http://www.ie.teicrete.gr\n"
                + "Εργαστήρια\n"
                + "Τηλ: 2810-379776\n"
                + "Τηλ: 2810-379708");

        setVisible(true);
        setTitle("Message");
        setSize(500, 200);
        
 
        pm.add(l1);
        

    }

}
