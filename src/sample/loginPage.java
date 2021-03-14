package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static sample.SignUpPage.openSignUpPage;

public class loginPage {
    private final Account account1 = new Account("Howard", "0123456789");
    private final Account account2 = new Account("lucathebest", "luca2002");
    private final Account account3 = new Account("Boobs", "42069");
    private final List<String> usernames = List.of(account1.getUsername(), account2.getUsername(), account3.getUsername());
    private final HashMap<Account, String> map = new HashMap<>();

    @FXML
    private Button contactInfo;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button signin;
    @FXML
    private Button signup;
    @FXML
    private Label failedSignInLabel;

    public void setLoginButtonAction() throws IOException {
        if (!(validUsername() && validPassword())) {
            failedSignInLabel.setText("Username or password is wrong!");
        } else {
            failedSignInLabel.setText("");
        }

    }

    public boolean validUsername() {
        boolean validUsername = false;
        if (usernames.stream().anyMatch(x -> username.getText().equals(account1.getUsername())
                || username.getText().equals(account2.getUsername())
                || username.getText().equals(account3.getUsername())))
            validUsername = true;
        return validUsername;
    }

    public boolean validPassword() {
        boolean validPassword = false;
        map.put(account1, account1.getPassword());
        map.put(account2, account2.getPassword());
        map.put(account3, account3.getPassword());
        boolean match = (username.getText().equals(account1.getUsername()) && password.getText().equals(map.get(account1)))
                || (username.getText().equals(account2.getUsername()) && password.getText().equals(map.get(account2)))
                || (username.getText().equals(account3.getUsername()) && password.getText().equals(map.get(account3)));
        if (match) validPassword = true;
        return validPassword;
    }

    public void setButtonAction() throws IOException {
        openSignUpPage();
    }
}
