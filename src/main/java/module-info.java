module org.computersector.javaeffectapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.computersector.javaeffectapp to javafx.fxml;
    exports org.computersector.javaeffectapp;
}