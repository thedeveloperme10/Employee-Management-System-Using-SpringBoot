package com.emsmanagementsystem.controllers;

import com.emsmanagementsystem.models.Department;
import com.emsmanagementsystem.models.Dependent;
import com.emsmanagementsystem.models.Insurance;
import com.emsmanagementsystem.models.Salary;
import com.emsmanagementsystem.services.CollectionsCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ems/colcreation")
public class CollectionsCreationController {

    @Autowired
    private CollectionsCreationService collectionsCreationService;

    @PostMapping(path = "/salary")
    public List<Salary> addSalaryData(@RequestBody List<Salary> salaries){
        return collectionsCreationService.addSalaryData(salaries);
    }

    @PostMapping(path = "/dependent")
    public List<Dependent> addDependentData(@RequestBody List<Dependent> dependents){
        return collectionsCreationService.addDependentData(dependents);
    }

    @GetMapping(path = "/getAllDependents")
    public List<Dependent> getAllDependents(){
        return collectionsCreationService.getAllDependents();
    }

    @PutMapping(path = "/updateDependentById/{id}")
    public Dependent updateDependentById(@PathVariable(value = "id") String id, @RequestBody Dependent dependent){
        return collectionsCreationService.updateDependentById(id, dependent);
    }

    @DeleteMapping(path = "/deleteDependentById/{id}")
    public void deleteDependentById(@PathVariable(value = "id") String id){
        collectionsCreationService.deleteDependentById(id);
    }

    @PostMapping(path = "/department")
    public List<Department> addDepartmentData(@RequestBody List<Department> departments){
        return collectionsCreationService.addDepartmentData(departments);
    }

    @PostMapping(path = "/insurance")
    public List<Insurance> addInsuranceData(@RequestBody List<Insurance> insurance){
        return collectionsCreationService.addInsuranceData(insurance);
    }

    @GetMapping(path = "/getAllInsurances")
    public List<Insurance> getAllInsurances(){
        return collectionsCreationService.getAllInsurances();
    }

    @PutMapping(path = "/updateInsuranceById/{id}")
    public Insurance updateInsuranceById(@PathVariable(value = "id") String id, @RequestBody Insurance insurance){
        return collectionsCreationService.updateInsuranceById(id, insurance);
    }

    @DeleteMapping(path = "/deleteInsuranceById/{id}")
    public void deleteInsuranceById(@PathVariable(value = "id") String id){
        collectionsCreationService.deleteInsuranceById(id);
    }
}
