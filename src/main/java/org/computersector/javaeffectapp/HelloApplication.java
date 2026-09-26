package org.computersector.javaeffectapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
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
    double blurVal;
    BoxBlur blur;
    Scale scale;
    double scaleVal;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("MyUIApp");

        scaleVal = 0.4;

        rotateButton = new Button("Rotate");

        scaleButton = new Button("Scale");
        blurButton = new Button("Blur");


        rotateButton.setOnAction(this);
        scaleButton.setOnAction(this);
        blurButton.setOnAction(this);

        label = new Label("Reflection adds visual sparkle");

        //Initializing effect objects
        rotate = new Rotate();
        scale = new Scale(scaleVal,scaleVal);
        blur = new BoxBlur(1,1,1);

        rotateButton.getTransforms().add(rotate);
        scaleButton.getTransforms().add(scale);

        GridPane flowPane = new GridPane();
//        FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL, 15,15);
//        flowPane.setAlignment(Pos.CENTER);


        flowPane.getChildren().addAll(rotateButton,scaleButton,blurButton,label);
        GridPane.setConstraints(rotateButton, 0,0);
        GridPane.setConstraints(scaleButton, 1,0);
        GridPane.setConstraints(blurButton, 2,0);
        GridPane.setConstraints(label, 3,1);




        Scene scene = new Scene(flowPane, 350,220);

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

            label.setText("Rotate : " + angle);
        }
        if(event.getSource().equals(blurButton))
        {
            if(blurVal == 10)
            {
                blurVal = 1.0;
                blurButton.setText("Blur OFF");
                blurButton.setEffect(null);
            }
            else
            {
                blurVal++;
                blurButton.setEffect(blur);
                blurButton.setText("Blur ON");
            }
            blur.setHeight(blurVal);
            blur.setWidth(blurVal);

            label.setText("blur : " + blurVal);
        }
        if(event.getSource().equals(scaleButton))
        {
            scaleVal += 0.1;
            if(scaleVal > 2.0)
            {
                scaleVal = 0.4;
            }

            scale.setX(scaleVal);
            scale.setY(scaleVal);
            label.setText("Scale : " + scaleVal);
        }

    }

    public static void main(String[] args) {
        launch();
    }


}