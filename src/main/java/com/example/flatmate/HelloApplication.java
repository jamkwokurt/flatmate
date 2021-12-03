package com.example.flatmate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        //Was test.
        /*
        new flatMate("gemma,gemma@gmail.com,389234723,1,2,4,3,3,5,200,300,Brooklyn");
        new mateSeeker("Alan,allan@gmail.com,74834823,3,4,1,2,4,6,280,Brooklyn,48 Flava Avenue");
        */

    }

    public static void main(String[] args) {
        launch();
    }
}