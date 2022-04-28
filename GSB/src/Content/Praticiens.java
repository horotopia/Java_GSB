package Content;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class Praticiens extends JFrame{
    private JButton OKButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton fermerButton;
    private JButton précédentButton;
    private JButton suivantButton;
    private JTextField textField9;
    private JComboBox comboBox1;
    private JPanel praPan;
    private ResultSet rs;
    private String statut;

    public Praticiens() {
        super("PRATICIENS");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setContentPane(praPan);
        pack();
        setVisible(true);

        try {
            statut = "next";
            rs = getTablePraticien();
            getComboboxId(rs);
            getInfoPraticien(rs, statut);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        suivantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    statut = "next";
                    getInfoPraticien(rs, statut);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        fermerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private ResultSet getTablePraticien() {
        Connect con = new Connect();
        con.connect();

        String query = "SELECT PRA_NUM, PRA_NOM, PRA_PRENOM, PRA_ADRESSE, PRA_CP, PRA_VILLE, PRA_COEFNOTORIETE, " +
                "type_praticien.TYP_CODE AS CODE, type_praticien.TYP_LIBELLE AS LIBELLE FROM praticien " +
                "INNER JOIN type_praticien ON type_praticien.TYP_CODE = praticien.TYP_CODE";
        System.out.println(query);

        ResultSet resultRequest = con.requete(query);
        return resultRequest;

    }

    private void getComboboxId(ResultSet rs) {
    }

    private void getInfoPraticien(ResultSet rs, String statut) throws SQLException {
        rs.next();
        textField2.setText(rs.getString("PRA_NUM"));
        textField3.setText(rs.getString("PRA_NOM"));
        textField4.setText(rs.getString("PRA_PRENOM"));
        textField5.setText(rs.getString("PRA_ADRESSE"));
        textField6.setText(rs.getString("PRA_CP"));
        textField9.setText(rs.getString("PRA_VILLE"));
        textField7.setText(rs.getString("PRA_COEFNOTORIETE"));
        textField8.setText(rs.getString("LIBELLE"));
    }
}
