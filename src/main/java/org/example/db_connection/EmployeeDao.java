package org.example.db_connection;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(int id);
    void save (Employee employee);
    void deleteById(int id);


}
