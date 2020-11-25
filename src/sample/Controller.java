package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class Controller {
    @FXML
    private TextField inputField;
    @FXML
    private ListView<String> listView;
    @FXML
    private Button sendButton;
    @FXML
    private TextArea chatHistory;
    @FXML
    private TextField textField;
    private TableView<RowWordFrequency> tableView;
    private Network network;

    public void addWord(){
        String word  = inputField.getText();

        addWordToList(word);
    }

    public void addWordToList(String word) {
        if(!word.isBlank()){
            listView.getItems().add(word);

        }
        inputField.setText("");
    }

    @FXML
    public void exit(){
        System.exit(0);
    }
    private void sendMessage(){
        String message = textField.getText();
        chatHistory.appendText(textField.getText());
        chatHistory.appendText(System.lineSeparator());
        textField.clear();

        try {
            network.getDataOutputStream().writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
            String errorMessage = "Ошибка при отправке";
            Main.showErrorMessage(e.getMessage(), errorMessage);
        }

    }

    public void setNetwork(Network network) {
        this.network = network;
    }
    public void appendMessage(String message){
        chatHistory.appendText(message);
        chatHistory.appendText(System.lineSeparator());
    }



}
