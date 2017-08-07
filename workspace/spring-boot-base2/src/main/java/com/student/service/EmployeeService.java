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

    ResponseEntity<Employee> addEmployee(Employee employee);

    ResponseEntity<Employee> getEmployee(int id);

    ResponseEntity<List<Employee>> getAllEmployees();

    ResponseEntity<Employee> modifyEmployee(Employee employee);

    ResponseEntity<Employee> deleteEmployee(int id);
}
