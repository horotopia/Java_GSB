package Views;

import javax.swing.*;
import Models.Connect;

public class CptRendu extends JFrame {
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

    public void test() {
        this.setContentPane(new CptRendu().pan);
        this.setTitle("Gestion des comptes rendus");
        this.setSize(800,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.con = new Connect();
    }


}
