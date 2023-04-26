package com.emsmanagementsystem.controllers;

import com.emsmanagementsystem.models.Employee;
import com.emsmanagementsystem.models.EntityWrapper;
import com.emsmanagementsystem.services.EMSEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ems/entity")
public class EMSEntityController {

    @Autowired
    private EMSEntityService emsEntityService;

    @GetMapping(path = "/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return emsEntityService.getAllEmployees();
    }

    @GetMapping(path = "/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") String id){
        return emsEntityService.getEmployeeById(id);
    }

    @PostMapping(path = "/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        return emsEntityService.addEmployee(employees);
    }

    @PutMapping(path = "/updateEmployeeById/{id}")
    public Employee updateEmployeeById(@PathVariable(value = "id") String id, @RequestBody Employee employee){
        return emsEntityService.updateEmployeeById(id, employee);
    }

    @DeleteMapping(path = "/deleteEmployeeById/{id}")
    public void deleteEmployeeById(@PathVariable(value = "id") String id){
        emsEntityService.deleteEmployeeById(id);
    }

    @GetMapping(path = "/getEmpWrapperById/{id}")
    public EntityWrapper getEmpWrapperById(@PathVariable(value = "id") String id){
        return emsEntityService.getEmpWrapperById(id);
    }
}
