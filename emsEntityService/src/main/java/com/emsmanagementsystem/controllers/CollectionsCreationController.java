package com.emsmanagementsystem.controllers;

import com.emsmanagementsystem.models.Department;
import com.emsmanagementsystem.models.Dependent;
import com.emsmanagementsystem.models.Insurance;
import com.emsmanagementsystem.models.Salary;
import com.emsmanagementsystem.services.CollectionsCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ems/colcreation")
public class CollectionsCreationController {

    @Autowired
    private CollectionsCreationService collectionsCreationService;

    @PostMapping(path = "/insurance")
    public List<Insurance> addInsuranceData(@RequestBody List<Insurance> insurance){
        return collectionsCreationService.addInsuranceData(insurance);
    }

    @PostMapping(path = "/salary")
    public List<Salary> addSalaryData(@RequestBody List<Salary> salaries){
        return collectionsCreationService.addSalaryData(salaries);
    }

    @PostMapping(path = "/dependent")
    public List<Dependent> addDependentData(@RequestBody List<Dependent> dependents){
        return collectionsCreationService.addDependentData(dependents);
    }

    @PostMapping(path = "/department")
    public List<Department> addDepartmentData(@RequestBody List<Department> departments){
        return collectionsCreationService.addDepartmentData(departments);
    }
}
