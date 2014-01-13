/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author jojofabe
 */
public class RangeModel extends InputModel{
    private SimpleStringProperty input; 

    //write a validation field and property here
    public SimpleStringProperty inputProperty() {
        return input;
    }

    public void setInput(SimpleStringProperty input) {
        this.input = input;
    }
    
    public RangeModel(String input) { 
        //might want to give out some useful information or error
        //message on the console log
        if(input != null || !input.equals(""))
            this.input = new SimpleStringProperty(input); 
        else this.input = new SimpleStringProperty(); 
    } 
    
    public String getInput() { return this.input.getValue();}
    
    public void setInput(String input) { 
        if (input != null || !input.equals(""))
            this.input.setValue(input);
        //give out some message
    } 
   
    //validate the input being given
    public void validateRangeInput() { 
        //do some minor validation in here to tell the user
        //that the input specified is not valid
    } 
    
}
