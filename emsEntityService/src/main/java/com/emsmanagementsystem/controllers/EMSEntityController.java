package com.emsmanagementsystem.controllers;

import com.emsmanagementsystem.models.Employee;
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

    @PostMapping(path = "/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return emsEntityService.addEmployee(employee);
    }
}