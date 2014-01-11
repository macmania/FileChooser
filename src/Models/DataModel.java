/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author jojofabe
 */
public class DataModel {
    public enum Employment {Employed, Unemployed}; 
    
    private SimpleStringProperty name = new SimpleStringProperty(""); 
    private SimpleObjectProperty<Employment> empl = new SimpleObjectProperty<>(); 
    private BooleanProperty isSelected; 
    
    public DataModel(String name, Employment empl, boolean isSelected){
        this.isSelected = new SimpleBooleanProperty(isSelected); 
        setName(name);
        setEmpl(empl); 
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
}


