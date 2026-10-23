package com.rest.models;
public class Table{
    public enum availability{
        occupied, free
    }
    private int id;
    private int capacity;
    private availability status;
     public Table(int id,int capacity){
        this.id=id;
        this.capacity=capacity;
        this.status=availability.free;
    }
    public int getId(){
        return id;
    }
    public int getCapacity(){
        return capacity;
    }
    public availability getStatus(){
        return status;
    }
    public void bookTable(){
        this.status=availability.occupied;
    }
    public void freeTable(){
        this.status=availability.free;
    }

}