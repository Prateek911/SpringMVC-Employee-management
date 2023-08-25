package com.mvc.employeeManagement.crud.exception;


import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleEmployeeNotFound(EmployeeNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error/employee-not-found";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGenericException(Exception ex, Model model) {
        model.addAttribute("errorMessage", "An error occurred");
        return "error/generic-error";
    }
}

