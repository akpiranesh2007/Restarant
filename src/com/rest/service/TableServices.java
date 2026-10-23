package com.rest.service;
import com.rest.models.Table;
import com.rest.repository.TableRepository;


public class TableServices {
    private final TableRepository tableRepository;
    public TableServices(){
        tableRepository=new TableRepository();
    }
    public void displayAllTables(){
        for(Table table:tableRepository.getTables()){
            System.out.println("Table ID: "+table.getId()+" Capacity: "+table.getCapacity()+" Status: "+table.getStatus());
        }
    }
    public void addTable(int id,int capacity){
        tableRepository.add(id,capacity);
    }
    public void removeTable(int id){
        tableRepository.remove(id);
    }
}
