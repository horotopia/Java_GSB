package Content;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Visiteurs extends JFrame{
    private JComboBox comboBox1;
    private JButton OKButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton fermerButton;
    private JButton suivantButton;
    private JButton precedentButton;
    private JPanel visPan;
    private String statut;
    private ResultSet rs;
    

    public Visiteurs() {
        super("VISITEURS");
        setSize(640,480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setContentPane(visPan);
        setVisible(true);

        try {
            statut = "next";
            rs = getTableVisiteur();
            getComboboxId(rs);
            getInfoVisiteur(rs, statut);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        OKButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = comboBox1.getSelectedItem().toString();
                String[] tabValues = value.split("\\s+");

                String setQuery = "SELECT VIS_MATRICULE, VIS_NOM, Vis_PRENOM, VIS_ADRESSE, VIS_CP, VIS_VILLE, " +
                        "VIS_DATEEMBAUCHE, secteur.SEC_CODE, secteur.SEC_LIBELLE AS secteur, " +
                        "labo.LAB_CODE, labo.LAB_NOM AS labNom FROM visiteur " +
                        "JOIN secteur ON secteur.SEC_CODE = visiteur.SEC_CODE " +
                        "JOIN labo ON labo.LAB_CODE = visiteur.LAB_CODE " +
                        "WHERE VIS_NOM ='"+tabValues[0]+"' AND VIS_PRENOM = '"+tabValues[1]+"'";

                ResultSet res = getTableVisiteur(setQuery);
                try {
                    res.next();
                    int row = res.getInt(1);
                    statut = "";
                    getInfoVisiteur(rs, statut, row);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
                    getInfoVisiteur(rs, statut);
                } catch (SQLException ex) {
                    ex.printStackTrace();
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
                    statut = "next";
                    getInfoVisiteur(rs, statut);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
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
    }

    private void getInfoVisiteur(ResultSet rs, String statut) throws SQLException {
        if (statut =="next") {
            System.out.println("suivant");
            if (rs.next()==false) {
                rs.first();
            }
        }
        if (statut == "previous") {
            System.out.println("précédent");
            if (rs.previous()==false) {
                rs.last();
            }
        }


        textField1.setText(rs.getString("VIS_NOM"));
        textField2.setText(rs.getString("VIS_PRENOM"));
        textField3.setText(rs.getString("VIS_ADRESSE"));
        textField4.setText(rs.getString("VIS_CP"));
        textField5.setText(rs.getString("VIS_VILLE"));
    }
    private void getInfoVisiteur(ResultSet rs, String statut, int row) throws SQLException{
        if (statut =="next") {
            System.out.println("suivant");
            if (rs.next()==false) {
                rs.first();
            }
        }
        if (statut == "previous") {
            System.out.println("précédent");
            if (rs.previous()==false) {
                rs.last();
            }
        }
        else
            rs.absolute(row);
        System.out.println(rs.getString("PRA_NUM"));


        textField1.setText(rs.getString("VIS_NOM"));
        textField2.setText(rs.getString("VIS_PRENOM"));
        textField3.setText(rs.getString("VIS_ADRESSE"));
        textField4.setText(rs.getString("VIS_CP"));
        textField5.setText(rs.getString("VIS_VILLE"));
    }

    private void getComboboxId(ResultSet rs) throws SQLException{
        ArrayList<String> listName = new ArrayList<String>();
        ArrayList<String> listSecteur = new ArrayList<String>();
        ArrayList<String> listLabo = new ArrayList<String>();

        while (rs.next()){
            String nom = rs.getString("VIS_NOM");
            String prenom = rs.getString("VIS_PRENOM");
            String fullName = nom + " " + prenom;
            listName.add(fullName);
            listSecteur.add(rs.getString("secteur"));
            listLabo.add(rs.getString("labNom"));


        }
        comboBox1.setModel(new DefaultComboBoxModel<>(listName.toArray()));
        comboBox2.setModel(new DefaultComboBoxModel<>(listSecteur.toArray()));
        comboBox3.setModel(new DefaultComboBoxModel<>(listLabo.toArray()));
    }

    private ResultSet getTableVisiteur() {
        Connect con = new Connect();
        con.connect();

        String query ="SELECT VIS_MATRICULE, VIS_NOM, Vis_PRENOM, VIS_ADRESSE, VIS_CP, VIS_VILLE, VIS_DATEEMBAUCHE, " +
                "secteur.SEC_CODE, secteur.SEC_LIBELLE AS secteur, labo.LAB_CODE, " +
                "labo.LAB_NOM AS labNom FROM visiteur JOIN secteur ON secteur.SEC_CODE = visiteur.SEC_CODE " +
                "JOIN labo ON labo.LAB_CODE = visiteur.LAB_CODE";

        System.out.println(query);

        ResultSet resultRequest = con.requete(query);
        return resultRequest;
    }
    public ResultSet getTableVisiteur(String setQuery) {
        Connect con = new Connect();
        con.connect();

        String query = setQuery;
        System.out.println(query);

        ResultSet resultRequest = con.requete(query);
        return resultRequest;
    }
}
