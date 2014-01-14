/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ViewModel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Input value model for the column input value
 */
public class InputValueModel {
    private StringProperty input = new SimpleStringProperty(""); 
    private ListProperty<String> choices = new SimpleListProperty<>(); 
    private ObservableList<String> list; 
    public InputValueModel(String input, ObservableList<String> options){
        if(input != null || !input.equals("")) 
            this.input.setValue(input);
        if(options != null || !options.isEmpty()) 
            options.setAll(options);
    }
    
    public InputValueModel(){
        list = FXCollections.observableArrayList();
        list.addAll("option 1", "option 1", "option 1");
        choices.set(list);
        input.setValue("option 1");
    }
    
    public ListProperty<String> choicesProperty(){
        return choices;
    }
    public StringProperty inputProperty() {
        return input;
    } 

    public String getInput() {
        return input.getValue();
    }

    public ObservableList<String> getChoices(){
        return choices.getValue();
    }
    
    public void setInput(String input) {
        this.input.set(input);
    }

    public void setChoices(ListProperty<String> choices) {
        this.choices.set(choices);
    }
}


