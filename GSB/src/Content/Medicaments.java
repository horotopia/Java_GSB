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
    private int page;
    private String statut;

    public Medicaments() {
        super("Medicaments");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(mediPan);
//        pack();
        setVisible(true);

        try {

            con = new Connect();
            con.connect();
            rs = con.requete("SELECT MED_DEPOTLEGAL, MEDICAMENT.FAM_CODE as fcode, FAMILLE.FAM_LIBELLE as libelle, MED_NOMCOMMERCIAL, MED_COMPOSITION, MED_EFFETS, MED_CONTREINDIC, MED_PRIXECHANTILLON FROM MEDICAMENT INNER JOIN FAMILLE ON MEDICAMENT.FAM_CODE = FAMILLE.FAM_CODE");

            //fillComboBox(con,"SELECT FAM_CODE FROM MEDICAMENT");
//            page = 0;
            fillComboBox(con,"SELECT MEDICAMENT.FAM_CODE, FAMILLE.FAM_LIBELLE FROM MEDICAMENT INNER JOIN FAMILLE ON MEDICAMENT.FAM_CODE = FAMILLE.FAM_CODE");


//            rs.next();
            remplirChamps(rs,"next"); // remplissage initial des champs à la première ouverture de la fenêtre Medicaments

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
                        statut = "previous";
                        remplirChamps(rs, statut);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
//                    try {
//                        rs.previous();
//                        remplirChamps();
//                        page = page - 1;
//                        familleComboBox.setSelectedIndex(page);
//                    } catch (SQLException ex) {
//                        //ex.printStackTrace();
//                        try {
//                            rs.last();
//                        } catch (SQLException exc) {
//                            //exc.printStackTrace();
//                        }
//                    }
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
                        statut = "next";
                        remplirChamps(rs, statut);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
//                    try {
//                        rs.next();
//                        remplirChamps();
//                        page = page + 1;
//                        familleComboBox.setSelectedIndex(page);
//                    } catch (SQLException ex) {
//                        //ex.printStackTrace();
//                        try {
//                            rs.first();
//                        } catch (SQLException exc) {
//                            //exc.printStackTrace();
//                        }
//                    }
                }
            });



        } catch (SQLException e)
        {   e.printStackTrace();    }

    }

    public void remplirChamps(ResultSet rs, String statut) throws SQLException {

        if (statut =="next") {
            System.out.println("suivant");
//            page = page + 1;
            if (rs.next()==false) {
                rs.first();
            }
        }
        if (statut == "previous") {
            System.out.println("précédent");
//            page = page - 1;
            if (rs.previous()==false) {
                rs.last();
            }
        }

        effetsTextArea.setLineWrap(true);
        effetsTextArea.setWrapStyleWord(true);

        codeTextField.setText(rs.getString("MED_DEPOTLEGAL"));
        nomComTextField.setText(rs.getString("MED_NOMCOMMERCIAL"));
        familleComboBox.setSelectedItem(rs.getString("libelle"));
//        familleComboBox.setSelectedIndex(page);
        compoTextField.setText(rs.getString("MED_COMPOSITION"));
        effetsTextArea.setLineWrap(true);
        effetsTextArea.setText(rs.getString("MED_EFFETS"));
        contreIndTextArea.setLineWrap(true);
        contreIndTextArea.setText(rs.getString("MED_CONTREINDIC"));
        prixTextField.setText(rs.getString("MED_PRIXECHANTILLON"));

    }

    public void fillComboBox(Connect connection, String query) throws SQLException{
        ResultSet res = connection.requete(query);
        String resultat ;
        ArrayList<String> liste = new ArrayList <String> ();
        while (res.next()){
            resultat =res.getString("FAM_LIBELLE");
            liste.add(resultat);
        }
        familleComboBox.setModel(new DefaultComboBoxModel<>(liste.toArray()));
    }
}
