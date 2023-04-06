package com.example.resumechecker;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ResumeChecker extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ResumeChecker.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 1064);
        stage.setTitle("Resume Checker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
