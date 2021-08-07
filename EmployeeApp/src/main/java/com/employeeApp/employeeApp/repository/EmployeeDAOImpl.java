package com.employeeApp.employeeApp.repository;

import com.employeeApp.employeeApp.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Employee> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee emp = session.get(Employee.class, id);
        return emp;
    }

    @Override
    @Transactional
    public void upsert(Employee e) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(e);
    }

    @Override
    @Transactional
    public Employee delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee emp = getEmployee(id);
        session.delete(emp);
        return emp;
    }
}
