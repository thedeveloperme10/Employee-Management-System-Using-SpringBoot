package com.emsmanagementsystem.services;

import com.emsmanagementsystem.models.Employee;
import com.emsmanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EMSEntityService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    public Employee updateEmployeeById(String id, Employee employee) {
        Optional<Employee> employees = employeeRepository.findById(id);
        if(employees.isPresent()){
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployeeById(String id) {
        Optional<Employee> employees = employeeRepository.findById(id);
        if(employees.isPresent()){
            employeeRepository.deleteById(id);
        }
    }
}
