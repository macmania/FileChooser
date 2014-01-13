/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

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

        boolean empty;
        public CheckBoxCellModel() {
            //checkBox = new CheckBox();
            //this.checkBox.setAlignment(Pos.CENTER);
            //setAlignment(Pos.CENTER);
            //checkBox.setVisible(true);
        //    checkBox.set
           // setGraphic(checkBox);
        //   this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
          // this.setEditable(true);
        }
       /*
        @Override
        public void startEdit() {
            super.startEdit();
            if (isEmpty()) {
                return;
            }
            checkBox.setDisable(false);
            checkBox.requestFocus();
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            checkBox.setDisable(true);
        }
        */
       @Override
        public void updateItem(Boolean item, boolean empty) {
           super.updateItem(item, empty);
           // this.empty = empty;
            if(!empty){
                checkBox = new CheckBox(); 
                setGraphic(checkBox);
                if (ov instanceof BooleanProperty) {
                    checkBox.selectedProperty().unbindBidirectional((BooleanProperty) ov);
                }
                TableColumn col = getTableColumn();
                TableView view = col.getTableView();
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