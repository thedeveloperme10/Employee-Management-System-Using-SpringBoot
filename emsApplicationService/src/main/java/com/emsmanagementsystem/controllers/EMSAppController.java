package com.emsmanagementsystem.controllers;

import com.emsmanagementsystem.models.Employee;
import com.emsmanagementsystem.services.EMSAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ems")
public class EMSAppController {

    @Autowired
    private EMSAppService emsAppService;

    @GetMapping(path = "/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return emsAppService.getAllEmployees();
    }

    @GetMapping(path = "/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") String id){
        return emsAppService.getEmployeeById(id);
    }

    @PostMapping(path = "/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return emsAppService.addEmployee(employee);
    }

    @PutMapping(path = "/updateEmployeeById/{id}")
    public Employee updateEmployeeById(@PathVariable(value = "id") String id, @RequestBody Employee employee){
        return emsAppService.updateEmployeeById(id, employee);
    }

    @DeleteMapping(path = "/deleteEmployeeById/{id}")
    public void deleteEmployeeById(@PathVariable(value = "id") String id){
        emsAppService.deleteEmployeeById(id);
    }
}
