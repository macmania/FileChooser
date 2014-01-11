package Models;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;

//temp class
public class DataModelFilter {
    SimpleStringProperty name = new SimpleStringProperty(""); 
    SimpleListProperty<DataModel> dataModList = new SimpleListProperty<>(); 
    
    public DataModelFilter(String str, DataModel add){
        setName(str); 
        addList(add); 
    }
    
    public void setName(String str){
        this.name.set(str);
    }
    
    public void addList(DataModel add){
        dataModList.add(add); 
    }
    
    public String getName(){ return this.name.getValue(); }
    
    public DataModel[] getDataList() {return (DataModel[]) dataModList.toArray();}
}