package org.example.db_connection;

import org.example.utils.Utils;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDao{
    @Override
    public List<Employee> findAll() {
        Connection con = DBConnection.getConnection();
        if(con == null){
            return null;
        }
        List<Employee> employees = new LinkedList<>();
        String query = "SELECT * FROM employee;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getBoolean("gender"),resultSet.getDate("birth_date"),resultSet.getDouble("salary"));
                employees.add(employee);
            }

        } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Connection con = DBConnection.getConnection();
        if(con == null){
            return null;
        }
        String query = "SELECT * FROM employee WHERE id=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){

            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Employee employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getBoolean("gender"),resultSet.getDate("birth_date"),resultSet.getDouble("salary"));
                return employee;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void save(Employee employee) {
        Connection con = DBConnection.getConnection();
        if(con == null) {
            return;
        }

        // Update
        if(employee.getId() >0){
            String query = "UPDATE employee SET name=? ,gender=? ,birth_date=? ,salary=? WHERE id=?;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)){
                preparedStatement.setString(1,employee.getName());
                preparedStatement.setBoolean(2,employee.isGender());
                preparedStatement.setDate(3, Utils.getSqlDate(employee.getBirthdate()));
                preparedStatement.setDouble(4,employee.getSalary());
                preparedStatement.setInt(5,employee.getId());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // Insert
        else {
            String query = "INSERT INTO employee (name, gender, birth_date, salary) VALUES (?, ?, ?, ?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)){
                preparedStatement.setString(1,employee.getName());
                preparedStatement.setBoolean(2,employee.isGender());
                preparedStatement.setDate(3, Utils.getSqlDate(employee.getBirthdate()));
                preparedStatement.setDouble(4,employee.getSalary());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteById(int id) {

        Connection con = DBConnection.getConnection();
        if(con == null) {
            return;
        }
        String query = "DELETE FROM employee WHERE id=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
