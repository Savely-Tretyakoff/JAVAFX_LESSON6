package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class RowWordFrequency {
    private SimpleStringProperty word;

    public RowWordFrequency(String word, int count) {
        this.word = new SimpleStringProperty(word);
    }
}
