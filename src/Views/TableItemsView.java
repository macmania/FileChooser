/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import Models.DataModel; 
import Models.DataModel.Employment;
import javafx.scene.control.TableColumn;
/**
 *
 * @author jojofabe
 */
public class TableItemsView<T> {
    @FXML private TableView<T> tableView; 
    
    @FXML private TableColumn checkBoxCol; 
    @FXML private TableColumn nameCol;
    @FXML private TableColumn valCol; 
    
    public TableItemsView(){
        tableView = new TableView<T>(); 
    }
 
    //adding some items in the list before hand
    public void showTable(){
       DataModel mod = new DataModel("", Employment.Employed, false); 
       DataModel mod2 = new DataModel("", Employment.Employed, false); 
       
    
    }
    
    
 
    
  
    
}
