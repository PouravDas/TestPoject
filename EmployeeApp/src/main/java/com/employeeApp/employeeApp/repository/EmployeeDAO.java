package com.employeeApp.employeeApp.repository;

import com.employeeApp.employeeApp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAll();

    public Employee getEmployee(int id);

    public void upsert(Employee e);

    public Employee delete(int id);
}
