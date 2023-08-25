package com.mvc.employeeManagement.crud.service;

import com.mvc.employeeManagement.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    void saveEmployee(Employee employee);
    void deleteEmployee(Long id);
}
