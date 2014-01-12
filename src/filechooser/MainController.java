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
import Models.DataModel;
import Models.DataModelFilter;
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.util.Callback;

/**
 *
 * @author jojofabe
 */
public class MainController implements Initializable {
   
    //These are the views that instantiate the particular view as 
    //appropriate
    File file; 
    @FXML private TableView<DataModel> tableView; 
   
    @FXML private TableColumn<DataModel, Boolean> checkBoxCol; 
    @FXML private TableColumn<DataModel, String> nameCol;
    @FXML private TableColumn<DataModel, DataModel.Employment> valCol; 
   
    @FXML private ListView<DataModelFilter> fileListView; 
    
    @FXML private Button loadFile; 
    @FXML private Button addFilter; 
    @FXML private Button saveFilter; 
    @FXML private Button removeFilter; 
    
    DropShadow shadow = new DropShadow(); 
    
    DataModel mod = new DataModel("one", DataModel.Employment.Employed, false); 
    DataModel mod2 = new DataModel("two", DataModel.Employment.Employed, false); 
       
    //adding some items in the list before hand
    public void showTable(){
       
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
       checkBoxCol.setCellFactory(call);
      
       nameCol.setCellValueFactory(new PropertyValueFactory<DataModel, String>("name"));
       
       valCol.setText("Value"); //DataModel.Employment.values()
       valCol.setCellValueFactory(new PropertyValueFactory<DataModel, DataModel.Employment>("empl"));
      
       tableView.getColumns().setAll(checkBoxCol, nameCol, valCol);
    }
    
    //shows sample test data in the list view 
    public void showListView(){
        //add all of the data model filters
        DataModelFilter modFilter = new DataModelFilter("first filter", null);
        DataModelFilter modFilter1 = new DataModelFilter("second filter", null);
        DataModelFilter modFilter2 = new DataModelFilter("third filter", null);
        
        
        ObservableList<DataModelFilter> listFilters = FXCollections.observableArrayList();
        listFilters.addAll(modFilter, modFilter1, modFilter2);
        
        fileListView.setCellFactory(new Callback<ListView<DataModelFilter>, ListCell<DataModelFilter>>(){

            
            @Override
            public ListCell<DataModelFilter> call(ListView<DataModelFilter> p) {
                final Label leadLbl = new Label(); 
                final ListCell<DataModelFilter> cell = new ListCell<DataModelFilter>(){
                    @Override
                    public void updateItem(DataModelFilter item, boolean empty){
                        super.updateItem(item, empty);
                        if(item != null){
                            leadLbl.setText(item.getName());
                            setText(item.getName());
                        }
                    }
                };
                return cell;
            }
                    
        });
        
        fileListView.setItems(listFilters);
    }
    
    

    
    //initialize the necessary items
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showTable();
        showListView(); 
    }    
    
    @FXML 
    public void handleLoadButton(MouseEvent e){
       if(e.getEventType() == MouseEvent.MOUSE_ENTERED){
           loadFile.setEffect(shadow);
           FileChooser chooseFile = new FileChooser(); 

           //Set extension filter
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("AVI files (*.avi)", "*.avi");
            chooseFile.getExtensionFilters().add(extFilter);
             
            //Show open file dialog
            file = chooseFile.showOpenDialog(null);

       }else if(e.getEventType() == MouseEvent.MOUSE_EXITED){
           loadFile.setEffect(null);
       }
    }
    
    @FXML 
    public void handleSaveFilterButton(MouseEvent e){
       if(e.getEventType() == MouseEvent.MOUSE_ENTERED){
           saveFilter.setEffect(shadow);
       }
       else if(e.getEventType() == MouseEvent.MOUSE_EXITED){
           saveFilter.setEffect(null);
       }
    }
    
    @FXML 
    public void handleAddFilterButton(MouseEvent e){
       if(e.getEventType() == MouseEvent.MOUSE_ENTERED){
           addFilter.setEffect(shadow);
       }
       else if(e.getEventType() == MouseEvent.MOUSE_EXITED){
           addFilter.setEffect(null);
       }
    }
    
    @FXML 
    public void handleRemoveFilterButton(MouseEvent e){
       if(e.getEventType() == MouseEvent.MOUSE_ENTERED){
           removeFilter.setEffect(shadow);
       }
       else if(e.getEventType() == MouseEvent.MOUSE_EXITED){
           removeFilter.setEffect(null);
       }
    }
}
