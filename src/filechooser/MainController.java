/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filechooser;

import Models.CheckBoxCellModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Views.*; 


import Models.DataModel;
import Models.DataModelFilter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
/**
 *
 * @author jojofabe
 */
public class MainController implements Initializable {
   
    //These are the views that instantiate the particular view as 
    //appropriate
    @FXML private TableView<DataModel> tableView; 
    
    @FXML private TableColumn<DataModel, Boolean> checkBoxCol; 
    @FXML private TableColumn<DataModel, String> nameCol;
    @FXML private TableColumn<DataModel, DataModel.Employment> valCol; 
   
    @FXML private ListView<DataModelFilter> fileListView = new ListView<>(); 
    
    @FXML private Button loadFile; 
    @FXML private Button addFilter; 
    @FXML private Button saveFile; 
    @FXML private Button removeFilter; 
    
 
    //adding some items in the list before hand
    public void showTable(){
       DataModel mod = new DataModel("one", DataModel.Employment.Employed, false); 
       DataModel mod2 = new DataModel("two", DataModel.Employment.Employed, false); 
       
       ObservableList<DataModel> listPeople = FXCollections.observableArrayList();
       listPeople.add(mod); listPeople.add(mod2); 
       
       tableView.setItems(listPeople);
       
       
       Callback call = new 
            Callback<TableColumn<DataModel, Boolean>, TableCell<DataModel, Boolean>>() {

           @Override
           public TableCell<DataModel, Boolean> call(TableColumn<DataModel, Boolean> p) {
             
               return new CheckBoxCellModel(); //To change body of generated methods, choose Tools | Templates.
           }
       };
      
      checkBoxCol.setCellValueFactory(new PropertyValueFactory<DataModel, Boolean>("isSelected"));
      //checkBoxCol.setCellFactory(CheckBoxTableCell.forTableColumn(checkBoxCol));
      checkBoxCol.setEditable(true);
       
      checkBoxCol.setCellFactory(call);
      
       nameCol.setCellValueFactory(new PropertyValueFactory<DataModel, String>("name"));
       
       valCol.setText("Value"); //DataModel.Employment.values()
       valCol.setCellValueFactory(new PropertyValueFactory<DataModel, DataModel.Employment>("empl"));
      
       tableView.getColumns().setAll(checkBoxCol, nameCol, valCol);
       
       System.out.println(checkBoxCol.getColumns().toArray().length);
       System.out.println(nameCol.getColumns().toArray().length);
       System.out.println(valCol.cellFactoryProperty().toString());
    }
    
    
    //initialize the necessary items
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showTable();
    }    
    
    @FXML 
    public void handleLoadButton(ActionEvent e){
        
    }
    
    @FXML 
    public void handleSaveFileButton(ActionEvent e){
        
    }
    
    @FXML 
    public void handleAddFilterButton(ActionEvent e){
        System.out.println("Hello"); 
    }
    
    @FXML 
    public void handleRemoveFilterButton(ActionEvent e){
    
    }
}
