/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filechooser;

import ViewModel.CheckBoxCellModel;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Models.DataModel;
import Models.DataModelFilter;
import ViewModel.MultiCellModel;
import java.io.File;
import java.io.IOException;
import java.util.function.Predicate;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    @FXML public TableView<DataModel> tableView; 
   
    @FXML private TableColumn<DataModel, Boolean> checkBoxCol; 
    @FXML private TableColumn<DataModel, String> nameCol;
    @FXML private TableColumn<DataModel, DataModel.Employment> valCol; 
    @FXML private TableColumn<DataModel, String> inputCol; 
    @FXML private ListView<DataModelFilter> fileListView; 
    
    @FXML private Button loadFile; 
    @FXML private Button addFilter; 
    @FXML private Button saveFilter; 
    @FXML private Button removeFilter; 
    
    @FXML private TextField filterNameText; 
    DropShadow shadow = new DropShadow(); 
    
    
    
    //sample data
    DataModel mod = new DataModel("one", DataModel.Employment.Employed, false); 
    DataModel mod2 = new DataModel("two", DataModel.Employment.Employed, false); 
    DataModel mod3 = new DataModel("three", DataModel.Employment.Unemployed, false); 
    DataModel mod4 = new DataModel("four", DataModel.Employment.Employed, false); 
    
    ObservableList<String> options1 = FXCollections.observableArrayList(); 
    ObservableList<String> options2 = FXCollections.observableArrayList(); 
    ObservableList<String> options3 = FXCollections.observableArrayList(); 
    ///InputDataModel in1 = new InputDataModel(null, 
  
    
    public void showTable(){
       ObservableList<DataModel> listPeople = FXCollections.observableArrayList();
       
       options1.addAll("choice1", "choice2", "choice3");
       options2.addAll("choice1", "choice2", "choice3");
       options3.addAll("choice1", "choice2", "choice3");
       
       Callback call = new 
            Callback<TableColumn<DataModel, Boolean>, TableCell<DataModel, Boolean>>() {

           @Override
           public TableCell<DataModel, Boolean> call(TableColumn<DataModel, Boolean> p) {
               
                //if(p.getUserData())
               return new CheckBoxCellModel() ; //To change body of generated methods, choose Tools | Templates.      
           }
       };
      
       checkBoxCol.setCellValueFactory(new PropertyValueFactory("isSelected"));
       checkBoxCol.setCellFactory(call);
       
       //specify which proeprty to sort it in
       
       nameCol.setCellValueFactory(new PropertyValueFactory<DataModel, String>("name"));
       
       valCol.setText("Value"); //DataModel.Employment.values()
       valCol.setCellValueFactory(new PropertyValueFactory<DataModel, DataModel.Employment>("empl"));
      
       inputCol.setText("Input");
       inputCol.setCellValueFactory(new PropertyValueFactory("input"));
       Callback callInput = new Callback<TableColumn<DataModel, Object>, TableCell<DataModel, Object>>(){
           
           @Override
           public TableCell<DataModel, Object> call(TableColumn<DataModel, Object> p) {
               //if(p.getUserData())
               return new MultiCellModel();
           }
       };
       inputCol.setCellFactory(callInput);
       
       tableView.getColumns().setAll(checkBoxCol, nameCol, valCol, inputCol);
    }
        
        ObservableList<DataModel> list = FXCollections.observableArrayList(mod, mod2); 
        ObservableList<DataModel> list2 = FXCollections.observableArrayList(mod3, mod4); 
        ObservableList<DataModel> list3 = FXCollections.observableArrayList(mod, mod2, mod3, mod4); 
    //add all of the data model filters
        DataModelFilter modFilter = new DataModelFilter("first filter", list);
        DataModelFilter modFilter1 = new DataModelFilter("second filter", list2);
        DataModelFilter modFilter2 = new DataModelFilter("third filter", list3);
        
    
    //shows sample test data in the list view 
    public void showListView(){
        
        ObservableList<DataModelFilter> listFilters = FXCollections.observableArrayList();
        System.out.println(mod.getInput().getClass());
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
                        else if(item == null){
                            setText("");
                        }
                    }
                };
                return cell;
            }    
        });
        
        fileListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<DataModelFilter>(){
            @Override
            public void changed(ObservableValue<? extends DataModelFilter> ov, DataModelFilter t, DataModelFilter t1) {
                if(ov != null && ov.getValue() != null ){
                    tableView.getItems();
                    tableView.setItems(ov.getValue().dataModListProperty());
                }
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
    public void handleLoadButton(MouseEvent e) throws IOException{
        if(e.getEventType() == MouseEvent.MOUSE_ENTERED){
           loadFile.setEffect(shadow);
           System.out.println("mouse entered"); 
           
        }else if (e.getEventType() == MouseEvent.MOUSE_CLICKED){
           FileChooser chooseFile = new FileChooser(); 
           File chosenFile = chooseFile.showOpenDialog(null);
        }
       else if(e.getEventType() == MouseEvent.MOUSE_EXITED){
           loadFile.setEffect(null);
       }
    }
    
    //Saves the filter criteria to a file specified by the user in the menu 
    //dialog
    @FXML 
    public void handleSaveFilterButton(MouseEvent e){
       if(e.getEventType() == MouseEvent.MOUSE_ENTERED){
           saveFilter.setEffect(shadow);
       }
       else if(e.getEventType() == MouseEvent.MOUSE_EXITED){
           saveFilter.setEffect(null);
       }
    }
    
    //add the filter specifications to the listview
    @FXML 
    public void handleAddFilterButton(MouseEvent e){
       if(e.getEventType() == MouseEvent.MOUSE_ENTERED){
           addFilter.setEffect(shadow);
       }
       else if(e.getEventType() == MouseEvent.MOUSE_CLICKED){
           //get the clickable items in table view and store it as a list and 
           //add it to the listView
           
           //need to ask Rob on how to better execute this part 
           final Predicate<DataModel> condition = new Predicate<DataModel>(){
               public boolean apply(DataModel model){
                   return model.isSelectedProperty().getValue();
               }

               @Override
               public boolean test(DataModel t) {
                   return apply(t); //To change body of generated methods, choose Tools | Templates.
               }
           };
           ObservableList<DataModel> list = tableView.getItems().filtered(condition);

           if(!filterNameText.getText().equals(""))
               addItemListView(list, filterNameText.getText());
           else addItemListView(list, "Filter" + fileListView.getItems().size());
       }
       else if(e.getEventType() == MouseEvent.MOUSE_EXITED){
           addFilter.setEffect(null);
       }
    }
    
    //adds another item in the list
    public void addItemListView(ObservableList<DataModel> list, String name){
        DataModelFilter filter = new DataModelFilter(name, list); 
        fileListView.getItems().add(filter);
    } 
    
    @FXML 
    public void handleRemoveFilterButton(MouseEvent e){
       if(e.getEventType() == MouseEvent.MOUSE_ENTERED){
           removeFilter.setEffect(shadow);
       }
       else if(e.getEventType() == MouseEvent.MOUSE_CLICKED){
           final int selectedIdx = fileListView.getSelectionModel().getSelectedIndex(); 
            if (selectedIdx != -1) {
                DataModelFilter itemToRemove = fileListView.getSelectionModel().getSelectedItem();
                final int newSelectedIdx = (selectedIdx == fileListView.getItems().size() - 1) ? selectedIdx - 1: selectedIdx;
                fileListView.getItems().remove(selectedIdx);
                fileListView.getSelectionModel().select(newSelectedIdx);
            }
       }
       else if(e.getEventType() == MouseEvent.MOUSE_EXITED){
           removeFilter.setEffect(null);
       }
    }
    
    @FXML 
    public void loadFile(){
        System.out.println("loading file");
    }
}
