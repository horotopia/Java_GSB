package Views;

import javax.swing.*;

public class Login extends JFrame {

    private JTextField textField1;
    private JButton OKButton;
    private JButton quitterButton;
    private JPasswordField passwordField1;
    private JLabel imgLabel;
    private JPanel pan;

    public Login() {
        ImageIcon img = new ImageIcon("logo.jpg");
        imgLabel = new JLabel("",img,JLabel.CENTER);
        this.setContentPane(new Login().pan);
        this.setTitle("Gestion des comptes rendus");
        this.setSize(800,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
