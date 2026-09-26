package org.computersector.javaeffectapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.Flow;

public class HelloApplication extends Application implements EventHandler {

    Button rotateButton;
    Button scaleButton;
    Button blurButton;
    Label label;
    Rotate rotate;
    double angle;


    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("MyUIApp");

        rotateButton = new Button("Rotate");
        scaleButton = new Button("Scale");
        blurButton = new Button("Blur");

        rotateButton.setOnAction(this);
        scaleButton.setOnAction(this);
        blurButton.setOnAction(this);


        label = new Label("Reflection adds visual sparkle");
        rotate = new Rotate();

        rotateButton.getTransforms().add(rotate);



        FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL, 15,15);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.getChildren().addAll(rotateButton,scaleButton,blurButton,label);
        Scene scene = new Scene(flowPane, 250,120);

        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void handle(Event event) {
        if(event.getSource().equals(rotateButton))
        {
            angle +=15;
            rotate.setAngle(angle);
            rotate.setPivotX(rotateButton.getWidth()/2);
            rotate.setPivotY(rotateButton.getHeight()/2);
        }
    }

    public static void main(String[] args) {
        launch();
    }


}