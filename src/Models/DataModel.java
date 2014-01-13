/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author jojofabe
 */
public class DataModel{
    public enum Employment {Employed, Unemployed}; 
    
    private SimpleStringProperty name;  
    private SimpleObjectProperty<Employment> empl;
    private BooleanProperty isSelected; 
    private SimpleObjectProperty<InputValueModel> inputModel; 
    private SimpleStringProperty userInput; 
    private ObjectProperty input; 
    
    public DataModel(String name, Employment empl, boolean isSelected){
        this.isSelected =  new SimpleBooleanProperty(isSelected);
        //setIsSelected(isSelected);//this.isSelected = new SimpleBooleanProperty(isSelected); 
        this.name = new SimpleStringProperty(name);
        this.empl = new SimpleObjectProperty<>(empl);
       
        this.isSelected.addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                System.out.println("changed");
            }
	});
        this.inputModel = new SimpleObjectProperty<InputValueModel> (); 
 
        if(this.empl.getValue() == Employment.Employed){
            input = new SimpleObjectProperty<InputValueModel>(); 
            assert input instanceof InputValueModel;
        }
        else if(this.empl.getValue() == Employment.Unemployed){
            input = new SimpleObjectProperty<RangeModel>(); 
            assert input instanceof RangeModel;
        }
            
    }
    
     public DataModel(String name, Employment empl, boolean isSelected, InputValueModel model){
        this.isSelected =  new SimpleBooleanProperty(isSelected);
        //setIsSelected(isSelected);//this.isSelected = new SimpleBooleanProperty(isSelected); 
        this.name = new SimpleStringProperty(name);
        this.empl = new SimpleObjectProperty<>(empl);
        this.inputModel = new SimpleObjectProperty<>(model);
        this.isSelected.addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                System.out.println("changed");
            }
	});
        
        if(this.empl.getValue() == Employment.Employed)
            input = new SimpleObjectProperty<InputValueModel>(); 
        else if(this.empl.getValue() == Employment.Unemployed)
            input = new SimpleObjectProperty<RangeModel>(); 
    }
    
    public BooleanProperty isSelectedProperty() {return isSelected;}
    public SimpleObjectProperty<Employment> emplProperty(){ return empl; }
    public StringProperty nameProperty(){return name;}
    public StringProperty userInputProperty() { return userInput;}
    public SimpleObjectProperty<InputValueModel> inputModelProperty(){return inputModel;}
            
    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Employment getEmpl() {
        return empl.getValue();
    }

    public void setEmpl(Employment empl) {
        this.empl.set(empl);
    }

    public boolean getIsSelected() {
        return isSelected.getValue();
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected.set(isSelected);
    }
    
    public void setInputModel(InputValueModel model){
        this.inputModel.set(model);
    }
    
    public InputValueModel getInputModel() { return inputModel.getValue();}
    
    
   
}


