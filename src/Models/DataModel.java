/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import ViewModel.InputValueModel;
import ViewModel.RangeModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
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
    private Property input; 
    
    public DataModel(String name, Employment empl, boolean isSelected){
        this.isSelected =  new SimpleBooleanProperty(isSelected);
        this.name = new SimpleStringProperty(name);
        this.empl = new SimpleObjectProperty<>(empl);
       
        this.isSelected.addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                System.out.println("changed");
            }
	});
 
        if(this.empl.getValue() == Employment.Employed){
            InputValueModel mod = new InputValueModel();
            
            input = new SimpleObjectProperty(); input.setValue(mod);
            System.out.println(input.getValue().getClass().toString()); 
            assert input.getValue() instanceof InputValueModel;
        }
        else if(this.empl.getValue() == Employment.Unemployed){
            input = new SimpleObjectProperty(new RangeModel()); 
        }
            
    }
    
     public DataModel(String name, Employment empl, boolean isSelected, InputValueModel model){
        this.isSelected =  new SimpleBooleanProperty(isSelected);
        this.name = new SimpleStringProperty(name);
        this.empl = new SimpleObjectProperty<>(empl);
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
    public Property inputProperty() {
        return input;
    }
    
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
    
    
    public void setInput(Object input){
        this.setInput(input);
    }
    
    public Object getInput() {System.out.println(input.getValue()); System.out.println(input.getValue().getClass()); return input.getValue();}
    
   
}


