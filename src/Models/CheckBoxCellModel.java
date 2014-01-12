/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class CheckBoxCellModel extends TableCell<DataModel, Boolean> {
       @FXML private CheckBoxCellModel checkBox;
       
        boolean empty; 
        public CheckBoxCellModel() {
            checkBox = new CheckBoxCellModel();
            checkBox.setAlignment(Pos.CENTER);
            
            this.setGraphic(checkBox);
            this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            this.setEditable(true);
        }
        
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
        
         @FXML TableView tableView;
        @Override
        public void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);
            this.empty = empty; 
            if (!isEmpty()) {
                
                checkBox.setOnMouseClicked(new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent t) {
                        
                        CheckBox cb = (CheckBox) t.getSource();
                        TableColumn column = (TableColumn)cb.getUserData();
                       
                        if(cb.isSelected()) { 
                            System.out.println(tableView.toString());
                            System.out.println("selected"); }
                        else System.out.println("not selected"); 
                    }
                });
                setGraphic(checkBox);
            }
            else{
                setGraphic(null);
               
            }
        }   
 }