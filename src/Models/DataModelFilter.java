package Models;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//temp class
public class DataModelFilter {
    StringProperty name; 
    SimpleListProperty<DataModel> dataModList = new SimpleListProperty<>(); 
    
    public DataModelFilter(String str, DataModel add){
        this.name = new SimpleStringProperty(str); 
        
        if (add != null) addList(add);
    }
    
    public void setName(String str){
        this.name.set(str);
    }
    
    public void addList(DataModel add){
        dataModList.add(add); 
    }
    
    public String getName(){ return this.name.getValue(); }
    
    public DataModel[] getDataList() {return (DataModel[]) dataModList.toArray();}
    
    public StringProperty nameProperty() {return name; }

    public SimpleListProperty<DataModel> dataModListProperty() {return dataModList;}
}
    