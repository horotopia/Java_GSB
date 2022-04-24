package Content;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    public JPanel pany;
    private JButton comptesRendusButton;
    private JButton visiteursButton;
    private JButton praticiensButton;
    private JButton medicamentsButton;
    private JButton quitterButton;

    public Menu(){
        super("Login");
        setSize(640,480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(pany);
        pack();
        setVisible(true);


        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
