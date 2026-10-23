package com.rest.CLI;
import com.rest.models.Table;
import com.rest.service.TableServices;
import java.util.Scanner;
public class TableCli {
    private final TableServices Services;
    Scanner scanner=new Scanner(System.in);
    public TableCli(TableServices Services){
        this.Services=Services;
    }
    public void start(){
        int choice;
        do{
            System.out.println("Table Management");

            System.out.println("1. All Tables");
            System.out.println("2. Add Table");
            System.out.println("3. Remove Table");
            System.out.println("0. Exit");
            choice=scanner.nextInt();
            switch(choice){
                case 1:
                    Services.displayAllTables();
                    break;
                case 2:
                    System.out.println("Enter ID:");
                    int a=scanner.nextInt();
                    System.out.println("Enter Capacity");
                    int b=scanner.nextInt();
                    Services.addTable(a,b);
                    break;
                case 3:
                    System.out.println("Enter ID:");
                    int c=scanner.nextInt();
                    Services.removeTable(c);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=0);
        }
    }

    

    

