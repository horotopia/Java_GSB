package Content;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public CptRendu() {
        setVisible(true);
        setSize(640,480);
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
    }


}
