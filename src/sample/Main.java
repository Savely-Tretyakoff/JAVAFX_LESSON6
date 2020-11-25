package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.awt.*;
import java.net.Socket;

public class Main extends Application {
    private final int SERVER_PORT = 8189;


    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("UI_UX.fxml"));
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("UI_UX.fxml"));

        Parent root = loader.load();

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Угроза");
        alert.setHeaderText("Это приложение содержит вредоносные файлы");
        alert.setContentText("Нажмите OK если хотите продолжить");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });


        primaryStage.setTitle("Messenger");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();


        Network network = new Network();
        if(!network.connect()){
            showErrorMessage("", "Ошибка подключения к серверу");
        }

        Controller controller = loader.getController();
        controller.setNetwork(network);

        network.waitMessage(controller);

        primaryStage.setOnCloseRequest(windowEvent -> network.close() );
    }

    public static void showErrorMessage(String message, String errorMessage){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Проблемы с соединением ");
        alert.setHeaderText(errorMessage);
        alert.setContentText(message);
        alert.showAndWait();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
