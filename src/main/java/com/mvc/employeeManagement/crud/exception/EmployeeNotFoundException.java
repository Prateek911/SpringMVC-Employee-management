package com.mvc.employeeManagement.crud.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id) {

        super("Employee Not found for id:"+id);
    }
}
