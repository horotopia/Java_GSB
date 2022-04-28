package Content;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Medicaments extends JFrame{
    private JPanel mediPan;
    private JButton precedentButton;
    private JButton suivantButton;
    private JButton fermerButton;
    private JTextArea effetsTextArea;
    private JTextArea contreIndTextArea;
    private JComboBox<Object> familleComboBox;
    private JTextField codeTextField;
    private JTextField nomComTextField;
    private JTextField compoTextField;
    private JTextField prixTextField;
    private Connect con;
    private ResultSet rs;

    public Medicaments() {
        super("Medicaments");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(mediPan);
        //pack();
        setVisible(true);

        try {

            con = new Connect();
            con.connect();
            rs = con.requete("SELECT MED_DEPOTLEGAL, FAM_CODE, MED_NOMCOMMERCIAL, MED_COMPOSITION, MED_EFFETS, MED_CONTREINDIC, MED_PRIXECHANTILLON FROM MEDICAMENT");

            fillComboBox(con,"SELECT MED_NOMCOMMERCIAL FROM MEDICAMENT");

            rs.next();
            remplirChamps(); // remplissage initial des champs à la première ouverture de la fenêtre Medicaments

            fermerButton.addActionListener(new ActionListener() {
                /**
                 * Ferme la fenêtre Medicaments
                 *
                 * @param e the event to be processed
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

            precedentButton.addActionListener(new ActionListener() {
                /**
                 * Invoked when an action occurs.
                 *
                 * @param e the event to be processed
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        rs.previous();
                        remplirChamps();
                    } catch (SQLException ex) {
                        //ex.printStackTrace();
                        try {
                            rs.last();
                        } catch (SQLException exc) {
                            //exc.printStackTrace();
                        }
                    }
                }
            });

            suivantButton.addActionListener(new ActionListener() {
                /**
                 * Invoked when an action occurs.
                 *
                 * @param e the event to be processed
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        rs.next();
                        remplirChamps();
                    } catch (SQLException ex) {
                        //ex.printStackTrace();
                        try {
                            rs.first();
                        } catch (SQLException exc) {
                            //exc.printStackTrace();
                        }
                    }
                }
            });



        } catch (SQLException e)
        {   e.printStackTrace();    }

    }

    public void remplirChamps() throws SQLException {

        effetsTextArea.setLineWrap(true);
        effetsTextArea.setWrapStyleWord(true);

        codeTextField.setText(rs.getString("MED_DEPOTLEGAL"));
        nomComTextField.setText(rs.getString("FAM_CODE"));
        familleComboBox.setSelectedItem(rs.getString("MED_NOMCOMMERCIAL"));
        compoTextField.setText(rs.getString("MED_COMPOSITION"));
        effetsTextArea.setText(rs.getString("MED_EFFETS"));
        contreIndTextArea.setText(rs.getString("MED_CONTREINDIC"));
        prixTextField.setText(rs.getString("MED_PRIXECHANTILLON"));

    }

    public void fillComboBox(Connect connection, String query) throws SQLException{
        ResultSet res = connection.requete(query);
        String resultat ;
        ArrayList<String> liste = new ArrayList <String> ();
        while (res.next()){
            resultat =res.getString("MED_NOMCOMMERCIAL");
            liste.add(resultat);
        }
        familleComboBox.setModel(new DefaultComboBoxModel<>(liste.toArray()));
    }
}
