package Content;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CptRendu extends JFrame {
    private JButton fermerButton;
    private JButton nouveauButton;
    private JButton suivantButton;
    private JButton precedentButton;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JComboBox<Object> comboBox1;
    private JTextField textField3;
    private JButton detailsButton;
    private JPanel pan;
    private JPanel comboBoxPanel;
    private Connect con;

    public CptRendu() throws SQLException {
        comboBoxPanel = new JPanel();
        setVisible(true);
        setSize(640,480);
        Connect connection = new Connect();
        connection.connect();
        fillComboBox(connection,"SELECT * FROM PRATICIEN");
        add(pan);
        /*
        pan = new JPanel();
        this.setTitle("Gestion des comptes rendus");
        this.setSize(800,600);
        Container CptRd = getContentPane();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(pan);
         */
//        this.con = new Connect();
//        return this;
        fermerButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        detailsButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void fillComboBox(Connect connection, String query) throws SQLException{
        ResultSet res = connection.requete(query);
        String nom, prenom, fullName ;
        ArrayList <String> listName = new ArrayList <String> ();
        int size = 0;
        while (res.next()){
            nom = res.getString("PRA_NOM");
            prenom = res.getString("PRA_PRENOM");
            fullName = nom + " " + prenom;
            listName.add(fullName);
            size++;
        }
        comboBox1.setModel(new DefaultComboBoxModel<>(listName.toArray()));
    }
}
