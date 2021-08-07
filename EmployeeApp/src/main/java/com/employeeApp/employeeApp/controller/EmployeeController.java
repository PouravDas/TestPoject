package com.employeeApp.employeeApp.controller;

import com.employeeApp.employeeApp.entity.Employee;
import com.employeeApp.employeeApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping(value = "/employee/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping(
            value = "/employee",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee upsertEmployee(@RequestBody Employee e) {
        employeeService.upsert(e);
        return e;
    }

    @DeleteMapping(value = "/employee/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee deleteEmployee(@PathVariable int id) {
        return employeeService.delete(id);
    }
}
