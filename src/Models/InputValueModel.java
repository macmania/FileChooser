/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 * Input value model for the column input value
 */
public class InputValueModel extends InputModel {
    private StringProperty input; 
    private ListProperty<String> choices = new SimpleListProperty<>(); 
    
    public InputValueModel(String input, ObservableList<String> options){
        if(input != null || !input.equals("")) this.input.setValue(input);
        if(options != null || !options.isEmpty()) options.setAll(options);
    }
    
    public InputValueModel(){
        choices.add("");
   //     choices.get().add("");
        
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


