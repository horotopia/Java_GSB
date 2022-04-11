package Views;

import javax.swing.*;
import Models.Connect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test extends JFrame {
    private JButton fermerButton;
    private JButton nouveauButton;
    private JButton suivantButton;
    private JButton précédentButton;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JButton détailsButton;
    private JPanel pan;
    private Connect con;
    private String query;
    private ResultSet rs;
    private String resultReq;


    public Test() {

    }

    public void test() {
        this.setContentPane(new Test().pan);
        this.setTitle("Gestion des comptes rendus");
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.con = new Connect();

        rs = con.requete("SELECT pra_nom, pra_prenom FROM praticien");
        try {
            while (rs.next()) {
                // Retrieve by column name

                System.out.println("Nom du labo : " + rs.getString("LAB_NOM"));
                System.out.println("Chef de vente : " + rs.getString("LAB_CHEFVENTE"));
                System.out.println();
                resultReq = resultReq+("Libellé : " + rs.getString("LAB_NOM")+"\n"+
                        "id : " + rs.getString("LAB_CHEFVENTE")+"\n\n");
            }
        }catch (SQLException e)
        {   e.printStackTrace();    }

        nouveauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("salut");
                textArea1.setText("salut");
//                query = textField1.getText();
//                con.setQuery(query);
//                resultReq = con.requete(query);

            }
        });
    }
}
