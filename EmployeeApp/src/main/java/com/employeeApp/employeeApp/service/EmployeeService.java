package com.employeeApp.employeeApp.service;

import com.employeeApp.employeeApp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAll();

    public Employee getEmployee(int id);

    public void upsert(Employee e);

    public Employee delete(int id);
}
