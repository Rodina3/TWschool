package com.student.controller;

import com.student.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rzhou on 04/08/2017.
 */


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService empService;

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return empService.addEmployee(employee);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        return empService.getEmployee(id);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return empService.getAllEmployees();
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> modifyEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        return empService.modifyEmployee(employee);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        return empService.deleteEmployee(id);
    }
}