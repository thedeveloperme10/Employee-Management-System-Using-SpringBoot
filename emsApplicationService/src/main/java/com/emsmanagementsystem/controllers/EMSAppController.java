package com.emsmanagementsystem.controllers;

import com.emsmanagementsystem.services.EMSAppService;
import com.emsmanagementsystem.models.Employee;
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

    @PostMapping(path = "/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return emsAppService.addEmployee(employee);
    }
}
