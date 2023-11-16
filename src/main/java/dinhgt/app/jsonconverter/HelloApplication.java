package dinhgt.app.jsonconverter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import static dinhgt.app.jsonconverter.constants.CommonConstants.HEIGHT_SCREEN;
import static dinhgt.app.jsonconverter.constants.CommonConstants.WIDTH_SCREEN;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Json-converter.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, WIDTH_SCREEN, HEIGHT_SCREEN);
        stage.setScene(scene);
        URL cssResource = HelloApplication.class.getResource("JSONColor.css");
        assert cssResource != null;
        scene.getStylesheets().add(cssResource.toExternalForm());
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}