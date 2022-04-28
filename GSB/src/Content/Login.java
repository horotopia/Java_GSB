package Content;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Login extends JFrame{
    private JButton okButton;
    private JTextField idField;
    private JPasswordField mdpField;
    private JButton quitterButton;
    public JPanel loginPan;
    private JLabel errorMessage;
    private String id;
    private String mdp;

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
                try {
                    mdp = String.valueOf(mdpField.getPassword());
                    id = idField.getText();

                    if (isValidUser(id, mdp)) {
                        new Menu();
                        dispose();
                    }
                    else{
                        errorMessage.setVisible(true);
                        errorMessage.setText("identifiant ou mot de passe invalide");
                    }
                }
                catch (SQLException | ParseException ex) {
                    ex.printStackTrace();
                    errorMessage.setVisible(true);
                    errorMessage.setText("identifiant ou mot de passe invalide");
                }
            }

            private static boolean isValidUser(String id, String mdp)
                    throws ParseException, SQLException {
                java.util.Date date = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH).parse(mdp);
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                mdp = formater.format(date);
                System.out.println("la date est : "+ mdp);
                Connect con = new Connect();
                con.connect();

                String query = "SELECT count(*) FROM visiteur WHERE VIS_NOM='" + id + "' AND VIS_DATEEMBAUCHE='" + mdp + "'";
                System.out.println(query);

                ResultSet resultRequest = con.requete(query);
                resultRequest.next();
                boolean isValidUser = resultRequest.getInt(1) > 0;
                System.out.println("result = "+ isValidUser);
                System.out.println();
                return isValidUser;
            }
        });
    }
}
