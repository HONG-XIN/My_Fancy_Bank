import javax.swing.*;
import java.awt.*;

/**
 * register panel for bank
 */
public class GUIBankRegisterPanel extends GUIBankPanel {

    // constructor
    public GUIBankRegisterPanel(GUIBankATMFrame frame) {
        super(frame);
        addElements();
    }

    // add elements
    public void addElements() {
        JButton loginButton = new JButton("LOGIN");
        GUIBankRegisterPanelLoginEvent loginEvent = new GUIBankRegisterPanelLoginEvent(getFrame());
        loginButton.addActionListener(loginEvent);

        setLayout(new GridLayout(6, 2));
        add(new JLabel("User name:"));
        add(new JTextField());
        add(new JLabel("Email"));
        add(new JTextField());
        add(new JLabel("Password:"));
        add(new JTextField());
        add(new JLabel(("Re-enter password:")));
        add(new JTextField());
        add(new JLabel());
        add(new JButton("REGISTER"));
        add(new JLabel());
        add(loginButton);
    }
}
