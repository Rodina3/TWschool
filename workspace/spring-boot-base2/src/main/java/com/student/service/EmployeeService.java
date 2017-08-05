package com.student.service;

import com.student.controller.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rzhou on 05/08/2017.
 */
@Service
public interface EmployeeService {

    public ResponseEntity<Employee> addEmployee(Employee employee);
    public ResponseEntity<Employee> getEmployee(int id);
    public ResponseEntity<List<Employee>> getAllEmployees();
    public ResponseEntity<Employee> modifyEmployee(Employee employee);
    public ResponseEntity<Employee> deleteEmployee(int id);
}
