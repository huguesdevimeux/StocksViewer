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
import java.util.Map;

import static sample.OpenContactInfo.openInfoPage;
import static sample.SignUpPage.openSignUpPage;

public class loginPage {
    private final Account account1 = new Account("Howard", "0123456789");
    private final Account account2 = new Account("lucathebest", "luca2002");
    private final Account account3 = new Account("Boobs", "42069");
    private Account createdAccount;
    private List<Account> usernames = new ArrayList<>();
    public final static Map<Account, String> map = new HashMap<>();
    private static List<Account> newUpdatedUsernames = new ArrayList<>();

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
        newUpdatedUsernames.addAll(List.of(account1, account2, account3));
        if (!(validUsername() && validPassword())) failedSignInLabel.setText("Username or password is wrong!");
        else {
            failedSignInLabel.setText("");
            StocksInfo.openStocksPage();
        }
    }

    public boolean validUsername() {
        boolean validUsername = false;
        if (newUpdatedUsernames.stream().anyMatch(x -> username.getText().equals(x.getUsername())))
            validUsername = true;
        return validUsername;
    }

    public boolean validPassword() {
        boolean validPassword = false;
        map.put(account1, account1.getPassword());
        map.put(account2, account2.getPassword());
        map.put(account3, account3.getPassword());

        boolean match = newUpdatedUsernames.stream().anyMatch(account -> password.getText().equals(map.get(account)));
        if (match) validPassword = true;
        return validPassword;
    }

    public void setButtonAction() throws IOException {
        openSignUpPage();
    }

    public List<Account> getUsernameList() {
        usernames.addAll(List.of(account1, account2, account3));
        return List.copyOf(usernames);
    }

    public void addAccount(String username, String password) {
        createdAccount = new Account(username, password);
        map.put(createdAccount, password);
        usernames.add(createdAccount);
        newUpdatedUsernames = usernames;
    }

    public void setContactInfoButtonAction() {
        openInfoPage();
    }

    public void open() throws IOException {
        StocksInfo.openStocksPage();
    }

    public void exit(){
        System.exit(0);
    }
}
