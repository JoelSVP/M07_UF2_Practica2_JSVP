package org.iespoblenou.m07_uf1_javafx_joelvinansaca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 520);
        stage.getIcons().add(new Image(getClass().getResource("/images_m7/m7-logo.png").toString()));
        scene.getStylesheets().addAll(Objects.requireNonNull(getClass().getResource("/style.css")).toExternalForm());
        stage.setTitle("Figuras");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}