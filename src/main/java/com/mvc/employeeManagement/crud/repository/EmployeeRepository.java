package com.mvc.employeeManagement.crud.repository;

import com.mvc.employeeManagement.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
