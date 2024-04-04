package org.iespoblenou.m07_uf1_javafx_joelvinansaca;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;

public class DibujarFigura {
    @FXML
    public Text textFigura;
    @FXML
    public VBox vBoxLayout;
    @FXML
    public RadioButton rButtonRectangle, rButtonTriangle, rButtonCircle, rButtonEllipse;
    @FXML
    public VBox vBox;
    @FXML
    private Rectangle rectangle;
    @FXML
    private Polygon triangle;
    @FXML
    private Circle circle;
    @FXML
    private Ellipse ellipse;
    @FXML
    private Pane pane;
    @FXML
    private Label labelColorFigura;
    @FXML
    private TextField textFieldColor;
    @FXML
    private Pane paneColor;
    @FXML
    private ImageView imageView;

    @FXML
    private Text textColor;

    @FXML
    public void initialize(){
        textFigura.setFill(Color.WHITE);
        textColor.setFill(Color.WHITE);
        rButtonCircle.setTextFill(Color.WHITE);
        rButtonRectangle.setTextFill(Color.WHITE);
        rButtonEllipse.setTextFill(Color.WHITE);
        rButtonTriangle.setTextFill(Color.WHITE);
        try {
            Image image = new Image(getClass().getResource("/images_m7/m7-logo.png").toString());
            imageView.setImage(image);
            imageView.setFitHeight(30);
            imageView.setFitWidth(30);
        } catch (Exception e) {
            System.err.println("No se pudo cargar la imagen.");
        }
    }

    public void cambiarForma(String color) {
        pane.getChildren().clear();
        Color figuraColor = Color.web(color);

        if (rButtonRectangle.isSelected()) {
            rectangle.setX(50);
            rectangle.setY(50);
            rectangle.setWidth(100);
            rectangle.setHeight(100);
            rectangle.setFill(figuraColor);
            pane.getChildren().add(rectangle);
        } else if (rButtonCircle.isSelected()) {
            circle.setCenterX(100.0f);
            circle.setCenterY(100.0f);
            circle.setRadius(50.0f);
            circle.setFill(figuraColor);
            pane.getChildren().add(circle);
        } else if (rButtonTriangle.isSelected()) {
            Polygon triangle = new Polygon();
            triangle.getPoints().addAll(new Double[]{
                    100.0, 10.0,
                    50.0, 100.0,
                    150.0, 100.0});
            triangle.setFill(figuraColor);
            pane.getChildren().add(triangle);
        } else if (rButtonEllipse.isSelected()) {
            ellipse.setCenterX(100.0f);
            ellipse.setCenterY(100.0f);
            ellipse.setRadiusX(50.0f);
            ellipse.setRadiusY(25.0f);
            ellipse.setFill(figuraColor);
            pane.getChildren().add(ellipse);
        } else {
            labelColorFigura.setTextFill(Color.RED);
            labelColorFigura.setText("Escoge una figura.");
            pane.getChildren().add(labelColorFigura);
        }
    }

    public void cambiarColor() {
        String colorForma = textFieldColor.getText().trim();
        paneColor.getChildren().clear();

        if (colorForma.length() == 7 && colorForma.startsWith("#")) {
            try {
                Color.web(colorForma);
                cambiarForma(colorForma);
            } catch (IllegalArgumentException e) {
                labelColorFigura.setTextFill(Color.RED);
                labelColorFigura.setText("Las letras del codigo deben ser de la A a la F.");
                paneColor.getChildren().add(labelColorFigura);
                System.err.println("Error: Las letras del codigo deben ser de la A a la F.");
            }
        } else if (colorForma.length() != 7) {
            labelColorFigura.setTextFill(Color.RED);
            labelColorFigura.setText("La cadena debe contar con 7 caracteres (contando el '#')");
            paneColor.getChildren().add(labelColorFigura);
        } else if (!colorForma.startsWith("#")) {
            labelColorFigura.setTextFill(Color.RED);
            labelColorFigura.setText("El hashtag '#' deberia estar al principio.");
            paneColor.getChildren().add(labelColorFigura);
        }
    }
}