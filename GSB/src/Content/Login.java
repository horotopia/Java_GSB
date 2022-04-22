package Content;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JButton okButton;
    private JLabel inditent;
    private JTextField idField;
    private JPasswordField mdpField;
    private JLabel mdp;
    private JButton quitterButton;
    private JLabel id;
    public JPanel loginPan;

    public Login() {
        super("Login");
        setSize(640,480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setContentPane(loginPan);
        pack();
        setVisible(true);

        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        okButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();
                remove();
//                JFrame frame = new JFrame("Menu");
//                frame.setContentPane(new Menu().pany);
//                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                frame.pack();
//                frame.setVisible(true);
//                remove();
            }
        });
    }
    public void remove() {
        this.dispose();
    }

}
