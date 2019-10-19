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
        JTextField usernameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField passwordField = new JTextField();
        JTextField password2Field = new JTextField();

        JLabel feedbackLabel = new JLabel();

        JButton registerButton = new JButton("REGISTER");
        GUIBankRegisterPanelRegisterEvent registerEvent = new GUIBankRegisterPanelRegisterEvent(getFrame());
        registerEvent.setUsernameField(usernameField);
        registerEvent.setEmailField(emailField);
        registerEvent.setPasswordField(passwordField);
        registerEvent.setPassword2Field(password2Field);
        registerEvent.setFeedbackLabel(feedbackLabel);
        registerButton.addActionListener(registerEvent);

        JButton loginButton = new JButton("LOGIN");
        GUIBankRegisterPanelLoginEvent loginEvent = new GUIBankRegisterPanelLoginEvent(getFrame());
        loginButton.addActionListener(loginEvent);

        setLayout(new GridLayout(6, 2));
        add(new JLabel("User name:"));
        add(usernameField);
        add(new JLabel("Email"));
        add(emailField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel(("Re-enter password:")));
        add(password2Field);
        add(feedbackLabel);
        add(registerButton);
        add(new JLabel());
        add(loginButton);
    }
}
