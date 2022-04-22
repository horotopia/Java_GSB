package Content;

import javax.swing.*;

public class Menu extends JFrame{
    private JCheckBox comptesRendusCheckBox;
    private JCheckBox visiteursCheckBox;
    private JCheckBox praticiensCheckBox;
    private JCheckBox medicamentsCheckBox;
    private JCheckBox quitterCheckBox;
    public JPanel pany;

    public Menu(){
        super("Login");
        setSize(640,480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(pany);
        pack();
        setVisible(true);
    }
}
