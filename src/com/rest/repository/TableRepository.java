package com.rest.repository;
import java.util.ArrayList;
import java.util.List;
import com.rest.models.Table;
public class TableRepository {
    private final List<Table> tables=new ArrayList<>();
    public TableRepository(){
        tables.add(new Table(1,4));
        tables.add(new Table(2,4));
        tables.add(new Table(3,2));
       
    }

    public List<Table> getTables(){
        return tables;
    }
    public List<Table> add(int id,int capacity){
        tables.add(new Table(id,capacity));
        return tables;
    }
    public List<Table> remove(int id){
        tables.removeIf(table->table.getId()==id);
        return tables;
    }


    
}
