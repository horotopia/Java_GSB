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
    private JPanel loginPan;

    public Login() {
        super("Login");
//        setTitle("Login2");
        setSize(640,480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container loginFenetre = getContentPane();
        BorderLayout flow1 = new BorderLayout();
        loginFenetre.setLayout(flow1);

        loginPan = new JPanel();

        loginPan.add(okButton);
        loginPan.add(inditent);
        loginPan.add(idField);
        loginPan.add(mdpField);
        loginPan.add(mdp);
        loginPan.add(quitterButton);
        loginPan.add(id);
        loginFenetre.add(loginPan,BorderLayout.NORTH);

        setContentPane(loginFenetre);

        setVisible(true);

        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
