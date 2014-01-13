/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ViewModel;

import Models.DataModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

public class CheckBoxCellModel extends CheckBoxTableCell<DataModel, Boolean> {
       private CheckBox checkBox;
       private ObservableValue<Boolean> ov;

       
       public CheckBoxCellModel() { }
      
       @Override
        public void updateItem(Boolean item, boolean empty) {
           super.updateItem(item, empty);

            if(!empty){
                checkBox = new CheckBox(); 
                
                setGraphic(checkBox);
                if (ov instanceof BooleanProperty) {
                    checkBox.selectedProperty().unbindBidirectional((BooleanProperty) ov);
                }
                ov = getTableColumn().getCellObservableValue(getIndex());
                if (ov instanceof BooleanProperty) {
                    checkBox.selectedProperty().bindBidirectional((BooleanProperty) ov);
                }
             }
                else{
                     setGraphic(null);
                }
        }
 }