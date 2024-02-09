//package Exception.Gui;
//
//import java.awt.*;
//
//import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.Label;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class Gui extends Application {
//
//    public static void save(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        Button button = new Button("Save");
//        button.setOnAction((event) -> {
//            SaveService saveService = new SaveService();
//            try {
//                saveService.save();
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Saved successfully", ButtonType.OK);
//                alert.getDialogPane().setStyle("-fx-font-family: 'serif'");
//                alert.showAndWait();
//            } catch (IOException e) {
//                Alert alert = new Alert(Alert.AlertType.ERROR, "Save failed", ButtonType.OK);
//                alert.getDialogPane().setStyle("-fx-font-family: 'serif'");
//                alert.showAndWait();
//            }
//        });
//        Scene scene = prepareScene(button);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private Scene prepareScene(Button button) {
//        VBox vBox = new VBox();
//        vBox.setAlignment(Pos.CENTER);
//        vBox.setPrefHeight(200);
//        vBox.setPrefWidth(300);
//        Label testGuiApplication = new Label("TestGuiApplication");
//        VBox innerVbox = new VBox();
//        innerVbox.setPrefHeight(60);
//        vBox.getChildren().addAll(testGuiApplication, innerVbox, button);
//        return new Scene(vBox);
//    }
//}