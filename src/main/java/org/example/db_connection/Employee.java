package org.example.db_connection;

import java.util.Date;

public class Employee {

    private int id;
    private String name;
    private boolean gender;
    private Date birthdate;
    private double salary;

    public Employee(){}

    public Employee(int id, String name, boolean gender, Date birthdate,double salary){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setBirthdate(Date birthday) {
        this.birthdate = birthday;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthdate=" + birthdate +
                ", salary=" + salary +
                '}';
    }
}
