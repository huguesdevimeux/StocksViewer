package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OpenContactInfo {
    @FXML
    private Hyperlink hyperlink = new Hyperlink();

    public static void openInfoPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(loginPage.class.getResource("ContactInfoPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Information page");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ignored) {
        }
    }

    public void openGithub() {
        openURL(hyperlink.getText());
    }

    public void openEmail() {
        openURL("https://mail.google.com/mail/u/0/#inbox?compose=XBcJlGZHLsJbgdcjwMxgwtjrtPZWVXGkBpGbwPRGZvBpQdvskCDThqnTRGLkVSPmGHgfngxRLjTFTNLl");
    }

    private void openURL(String URL) {
        try {
            Desktop.getDesktop().browse(new URI(URL));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }
}
