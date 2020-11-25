package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ViewController {




    @FXML
    private Button sendButton;
    @FXML
    private TextArea chatHistory;
    @FXML
    private TextField textField;

    private Network network;

    @FXML
    public void initialize(){
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) { ViewController.this.sendMessage();}

            });
        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) { ViewController.this.sendMessage();}

            });
    }
    private void sendMessage(){
        chatHistory.appendText(textField.getText());
        chatHistory.appendText(System.lineSeparator());
        textField.clear();
    }
    public void setNetwork(Network network){
        this.network = network;
    }


}
