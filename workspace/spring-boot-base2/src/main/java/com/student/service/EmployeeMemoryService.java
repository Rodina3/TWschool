package com.student.service;

import com.student.controller.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzhou on 04/08/2017.
 */

@Service
public class EmployeeMemoryService implements EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    private Employee findElementById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return (Employee) null;
    }

    public ResponseEntity<Employee> addEmployee(Employee employee) {
        employees.add(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    public ResponseEntity<Employee> getEmployee(int id) {
        if (findElementById(id) != null) {
            return new ResponseEntity<Employee>(findElementById(id), HttpStatus.OK);
        }
        return new ResponseEntity<Employee>((Employee) null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    public ResponseEntity<Employee> modifyEmployee(Employee employee) {
        Employee emp = findElementById(employee.getId());
        if (emp != null) {
            emp.setName(employee.getName());
            emp.setId(employee.getId());
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>((Employee) null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Employee> deleteEmployee(int id) {
        Employee employee = findElementById(id);
        if (employee != null) {
            employees.remove(employee);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<Employee>((Employee) null, HttpStatus.NOT_FOUND);
    }
}
