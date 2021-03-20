package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static sample.OpenContactInfo.openInfoPage;
import static sample.SignUpPage.openSignUpPage;

public class loginPage {
    private final Account account1 = new Account("Howard", "0123456789");
    private final Account account2 = new Account("lucathebest", "luca2002");
    private final Account account3 = new Account("Boobs", "42069");
    private Account createdAccount;
    private List<String> usernames = new ArrayList<>();
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
        usernames.addAll(List.of(account1.getUsername(), account2.getUsername(), account3.getUsername()));
        if (!(validUsername() && validPassword())) {
            failedSignInLabel.setText("Username or password is wrong!");
        } else {
            failedSignInLabel.setText("");
            StocksInfo.openStocksPage();
        }

    }

    public boolean validUsername() {
        boolean validUsername = false;
        if (usernames.stream().anyMatch(x -> username.getText().equals(account1.getUsername())
                || username.getText().equals(account2.getUsername())
                || username.getText().equals(account3.getUsername())
        ))
            validUsername = true;
        //List<Account> a = List.of(account1, account2, account3);
        //usernames.stream().noneMatch(a.iterator().toString()::equals);
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

    public List<String> getUsernameList() {
        usernames.addAll(List.of(account1.getUsername(), account2.getUsername(), account3.getUsername()));
        return List.copyOf(usernames);
    }

    public void addAccount(String username, String password) {
        createdAccount = new Account(username, password);
        usernames.add(createdAccount.getUsername());
    }

    public void setContactInfoButtonAction() throws IOException {
        openInfoPage();
    }

    public void open() throws IOException {
        StocksInfo.openStocksPage();
    }
}
