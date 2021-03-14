package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static void openSignUpPage() throws IOException{
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
}
