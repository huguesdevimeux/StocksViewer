package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SignUpPage {

    @FXML
    private TextField name;
    @FXML
    private TextField lastName;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField username;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label wrongPasswordLabel;
    @FXML
    private Label wrongSignUpLabel;
    @FXML
    private Button signUpButton;
    @FXML
    private Button generatePassword;
    @FXML
    private RadioButton radioButton;

    private loginPage a = new loginPage();
    private List<Account> currentAccountsUsernames = a.getUsernameList();
    private final PasswordVerificator passwordVerificator = new PasswordVerificator();
    public static Account createdAccount;

    public static void openSignUpPage() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(loginPage.class.getResource("SignUpPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Sign Up");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ignored) {
        }
    }

    public void passwordRandomizer() {
        //setting length beneath 20 character
        int stringLength = (int) (Math.random() * 20);
        //conditioning string length to be over 8 characters;
        while (stringLength < 8) stringLength = (int) (Math.random() * 20);
        passwordField.setText(StringRandomizer.generateString(stringLength));
    }

    public void setRadioButtonAction() {
        String password = passwordField.getText();
        passwordField.clear();
        passwordField.setPromptText(password);
    }

    public void abilityToSignUp() {
        boolean valid = !(name.getText().isBlank() || lastName.getText().isBlank()) && validPassword() && validUsername();
        if (valid) {
            wrongSignUpLabel.setText("SIGN UP SUCCESSFUL :)");
            wrongSignUpLabel.setTextFill(Color.GREEN);
            a.addAccount(username.getText(), passwordField.getText());
            reOpenUpdatedLoginPage();
        } else {
            wrongSignUpLabel.setText("Username or Password is wrong");
            wrongSignUpLabel.setTextFill(Color.RED);
        }
    }

    public boolean validUsername() {
        return currentAccountsUsernames.stream().noneMatch(x -> username.getText().equals(x.getUsername()));
    }

    public boolean validPassword() {
        return passwordVerificator.userPassword(passwordField.getText());
    }

    public void reOpenUpdatedLoginPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(loginPage.class.getResource("loginPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ignored) {
        }
    }
}
