package Models;

import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

//temp class
public class DataModelFilter{
    StringProperty name; 
    ListProperty<DataModel> dataModList = new SimpleListProperty<>(); 
    
    // @Override
    public DataModelFilter(String name, ObservableList<DataModel> listModels){
        if(listModels != null)
            dataModList.set(listModels);//;addAll(listModels);
        this.name = new SimpleStringProperty(name); 
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

    public ListProperty<DataModel> dataModListProperty() {return dataModList;}

    
}
    