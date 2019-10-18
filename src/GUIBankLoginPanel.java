import javax.swing.*;
import java.awt.*;

/**
 * login in panel for bank ATM
 */
public class GUIBankLoginPanel extends GUIBankPanel {
    // constructor
    public GUIBankLoginPanel(GUIBankATMFrame frame, Bank bank) {
        super(frame, bank);
        addElements();
    }

    // other function
    public void addElements() {
        JTextField usernameField = new JTextField();
        JTextField passwordField = new JTextField();

        JLabel feedbackLabel = new JLabel();

        JButton loginButton = new JButton("LOGIN");
        GUIBankLoginPanelLoginEvent loginEvent = new GUIBankLoginPanelLoginEvent(getFrame(), getBank());
        loginEvent.setUsernameField(usernameField);
        loginEvent.setPasswordField(passwordField);
        loginEvent.setFeedbackLabel(feedbackLabel);
        loginButton.addActionListener(loginEvent);

        JButton registerButton = new JButton("REGISTER");
        GUIBankLoginPanelRegisterEvent registerEvent = new GUIBankLoginPanelRegisterEvent(getFrame(), getBank());
        registerButton.addActionListener(registerEvent);

        setLayout(new GridLayout(4, 2));
        add(new JLabel("User Name:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(feedbackLabel);
        add(loginButton);
        add(new JLabel());
        add(registerButton);
    }
}
