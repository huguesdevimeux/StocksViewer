package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    private final String OPEN_SEARCH = "https://www.google.com/search?q=";

    public static void openStocksPage() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(loginPage.class.getResource("StocksInfo.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Information page");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openURL(String URL) {
        try {
            Desktop.getDesktop().browse(new URI(URL));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void setvBox() {
        Button open = new Button("open");
        TextField stockName = new TextField();
        stockName.setPromptText("enter Stock name");
        vBox.getChildren().add(stockName);
        vBoxOpenUrl.getChildren().add(open);
        open.setOnAction(event ->
                openURL(OPEN_SEARCH + stockName.getText().replace(" ", "+") + "+stocks"));
    }
    public void exit(){
        System.exit(0);
    }
}
