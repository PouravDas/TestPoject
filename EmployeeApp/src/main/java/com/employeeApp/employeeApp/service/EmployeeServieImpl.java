package com.employeeApp.employeeApp.service;

import com.employeeApp.employeeApp.entity.Employee;
import com.employeeApp.employeeApp.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServieImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    public void upsert(Employee e) {
        employeeDAO.upsert(e);
    }

    @Override
    public Employee delete(int id) {
        return employeeDAO.delete(id);
    }
}
