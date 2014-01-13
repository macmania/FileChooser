/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;

/**
 * multiple options for rendering table cells 
 * @author jojofabe
 */
public class MultiCellModel extends TableCell<DataModel, Object>{
    TextField textField; 
    ComboBox comboBox; 
    
    public MultiCellModel(){
       
        if (getItem() instanceof InputValueModel) {
            comboBox = new ComboBox(); 
            if (comboBox != null) {
              comboBox.setValue(((InputValueModel)getItem()).getInput());
            }
            setText(null);
            setGraphic(comboBox);
       }else if(getItem() instanceof RangeModel) {
            textField = new TextField();  
            //setText(null);
            setGraphic(textField);
            textField.setEditable(true);
          } 
    }
    
    @Override 
    public void startEdit() {
        if (!isEmpty()) {
          super.startEdit();

          if (getItem() instanceof RangeModel) {
            createTextField();
            setText(null);
            setGraphic(textField);
            textField.selectAll();
          } else if (getItem() instanceof InputValueModel){
            createComboBox();
            setText(null);
            setGraphic(comboBox);
          }  
        }
    }
    
    @Override 
    public void cancelEdit(){
        super.cancelEdit();
        
        if(getItem() instanceof String)
            setText((String)getItem()); 
        
        setGraphic(null);    
    }
    
    @Override public void updateItem(Object item, boolean empty) {
      super.updateItem(item, empty);
 
      if (empty) {
        setText(null);
        setGraphic(null);
      } else {
          if (item instanceof InputValueModel) {
            comboBox = new ComboBox(); 
            if (comboBox != null) {
              comboBox.setValue(((InputValueModel)item).getInput());
            }
            setText(null);
            setGraphic(comboBox);
          } else if(item instanceof RangeModel) {
            textField = new TextField(); 
              if (textField != null) {
              textField.setText(getInputString());
            }
            setText(null);
            setGraphic(textField);
          }  
        } 
      }
 
    private void createTextField() {
      assert getItem() instanceof String; 
      textField = new TextField(getInputString());
      textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
      textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
          if (!newValue) {
            commitEdit(textField.getText());
          }
        }
      });
    }
 
    private void createComboBox() {
      assert getItem() instanceof InputValueModel; 
      comboBox = new ComboBox(); 
      comboBox.getItems().setAll(((InputValueModel)getItem()).choicesProperty());
      comboBox.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
      comboBox.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
          if (!newValue) {
              System.out.println(comboBox.getSelectionModel().getSelectedItem());
              commitEdit(comboBox.getSelectionModel().getSelectedItem());
          }
        }
      });
    }
 
    public String getInputString(){
        assert getItem() instanceof String; 
        return getItem() != null ? getItem().toString() : "";
    }
    
   
}
