package com.mvc.employeeManagement.crud.controller;

import com.mvc.employeeManagement.crud.entity.Employee;
import com.mvc.employeeManagement.crud.exception.EmployeeNotFoundException;
import com.mvc.employeeManagement.crud.service.EmployeeService;
import com.mvc.employeeManagement.crud.utility.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("employees", employeeList);
        return "employee/list";
    }

    @GetMapping("/employee/{id}")
    public String getEmployeeDetails(@PathVariable Long id, Model model) {
        Employee employee = Optional.ofNullable(employeeService.getEmployeeById(id)).orElseThrow(() -> new EmployeeNotFoundException(id));

        model.addAttribute("employee", employee);

        return "employee/details";
    }


    @PostMapping("/add")
    public String addEmployees(@ModelAttribute @Valid Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "employee/add";
        }

        employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute(Constants.MESSAGE,"Employee Added Successfully");
        return Constants.REDIRECT_URL;

    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, @ModelAttribute @Valid Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "employee/edit";
        }

        employee.setId(id);
        employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "Employee updated successfully!");
        return Constants.REDIRECT_URL;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, RedirectAttributes redirectAttributes ){

        Optional.ofNullable(employeeService.getEmployeeById(id)).orElseThrow(()->new EmployeeNotFoundException(id));

        employeeService.deleteEmployee(id);
        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "Employee Successfully Deleted");
        return Constants.REDIRECT_URL;

    }

}
