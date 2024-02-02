package org.example;

import org.example.db_connection.DBConnection;
import org.example.db_connection.Employee;
import org.example.db_connection.EmployeeDao;
import org.example.db_connection.EmployeeDaoImp;

import java.sql.Connection;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();
        if(con == null){
            System.out.println("connection failed");
        }
        else{
            System.out.println("connection success");
        }

    }
}