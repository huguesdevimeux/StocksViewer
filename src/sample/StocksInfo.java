package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class StocksInfo {
    @FXML
    private VBox vBox;
    @FXML
    private VBox vBoxOpenUrl;
    @FXML
    private VBox vBoxBis;

    public static void openStocksPage() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(loginPage.class.getResource("StocksInfo.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Information page");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ignored) {
        }
    }

    private void openURL(String URL) {
        try {
            Desktop.getDesktop().browse(new URI(URL));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }

    public void setvBox() {
        vBox.getChildren().add(new TextField("Set Stock Name"));
        vBoxBis.getChildren().add(new TextField("enter URL"));
        vBoxOpenUrl.getChildren().add(new Button("Open"));
    }

    public void openStockURL() {
        for (Node node : vBoxOpenUrl.getChildren()) {
            for (int i = 0; i < vBoxBis.getChildren().size(); i++) {
                openURL(vBoxBis.getChildren().get(i).getAccessibleText());
            }
        }
    }

}
