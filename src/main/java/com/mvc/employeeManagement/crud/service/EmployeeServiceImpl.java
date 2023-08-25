package com.mvc.employeeManagement.crud.service;

import com.mvc.employeeManagement.crud.entity.Employee;
import com.mvc.employeeManagement.crud.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void saveEmployee(Employee employee) {

        employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployee(Long id) {

        employeeRepository.deleteById(id);

    }
}
