package Content;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Multi extends JFrame {
    private JPanel multiPan;
    private JCheckBox bouton;
    private JButton button1;
    private CptRendu test1;

    public Multi() {
        super("test");
        setSize(100, 80);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container fene1 = getContentPane();
//        BorderLayout flow1 = new BorderLayout();
//        fene1.setLayout(flow1);

        JPanel pan1 = new JPanel();

        bouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
//                test1 = new CptRendu();
//                JFrame fenetre2 = new JFrame("Alerte");
//                fenetre2.setSize(300,70);
//                Container fene2 = getContentPane( );
//                BorderLayout flow2 = new BorderLayout( );
//                fene2.setLayout(flow2);
//
//                JPanel pan2 = new JPanel();
////                pan2.add(message);
//                fene2.add(pan2,BorderLayout.NORTH);
//
//                fenetre2.setContentPane(fene2);
//                fenetre2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//                fenetre2.setVisible(true);
            }
        });

        pan1.add(bouton);
        pan1.add(button1);
        fene1.add(pan1,BorderLayout.NORTH); // d"

        setContentPane(fene1);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //l'action appel une new fenetre et ferme multi
//                test1 = new CptRendu(); //CompteRendu
                remove();//fonction this.dispose
            }
        });
    }

    public static void main(String [] args) {
        Multi test = new Multi();
    }

    public void remove() {
        this.dispose();
    } //c'est comme ça qu'on a fait

}
