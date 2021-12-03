package com.example.flatmate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

import java.sql.*;
import java.util.ArrayList;

public class HelloApplication extends Application {

    ResultSet resultSet;
    ArrayList<flatMate> list = new ArrayList<flatMate>();
    @Override
    public void start(Stage stage) throws IOException {



        try {
            Connection connection = null;
            String databaseUser = "admin";
            String databasePass = "password123456";
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://database-1.c2jsskezjm38.ap-southeast-2.rds.amazonaws.com:3306/aws_first_DB";
            connection = DriverManager.getConnection(url, databaseUser, databasePass);
            Statement s = connection.createStatement();
            resultSet = s.executeQuery("select * from userdata");
            while (resultSet.next()) {
                list.add(new flatMate(resultSet));
                System.out.println(resultSet.getString("name"));
            }
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        VBox container = new VBox();
        container.setAlignment(Pos.TOP_CENTER);
        Text title = new Text("Flatmate Finder");
        title.setFont(new Font("Arial", 48));
        title.setTextAlignment(TextAlignment.CENTER);
        Text subtitle = new Text("I am . . . ");
        subtitle.setTextAlignment(TextAlignment.CENTER);
        HBox.setMargin(subtitle, new Insets(50, 0, 0, 0));
        HBox buttonCont = new HBox();
        buttonCont.setAlignment(Pos.TOP_CENTER);
        Button flatHunterButton = new Button("Looking for a flat");
        flatHunterButton.setOnAction(
                event->{
                    new FlatmateForm(container, list);
                }
        );
        Button flatmateHunterButton = new Button("Looking for a flatmate");

        buttonCont.getChildren().addAll(flatHunterButton,flatmateHunterButton);
        container.getChildren().addAll(title,subtitle,buttonCont);
        Scene mainScene = new Scene(container,500,300);
        stage.setTitle("Hello!");
        stage.setScene(mainScene);
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