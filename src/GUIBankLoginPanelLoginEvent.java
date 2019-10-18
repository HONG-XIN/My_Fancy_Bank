import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * event when user clicks the LOGIN button in login panel
 */
public class GUIBankLoginPanelLoginEvent extends GUIBankEvent {
    // instance variables with private access
    private JTextField usernameField;
    private JTextField passwordField;
    private JLabel feedbackLabel;

    // constructor
    public GUIBankLoginPanelLoginEvent(GUIBankATMFrame frame, Bank bank) {
        super(frame, bank);
    }

    // mutator functions
    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public void setPasswordField(JTextField passwordField) {
        this.passwordField = passwordField;
    }

    public void setFeedbackLabel(JLabel feedbackLabel) {
        this.feedbackLabel = feedbackLabel;
    }

    // primary functions
    public void actionPerformed(ActionEvent e) {
        System.out.println("LOGIN button clicked.");
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        Bank bank = getBank();
        if (bank.memberLogin(username, password)) {
            feedbackLabel.setText("Success!");
            feedbackLabel.setForeground(Color.GREEN);
        } else {
            feedbackLabel.setText("Invalid password!");
            feedbackLabel.setForeground(Color.RED);
        }
    }
}
