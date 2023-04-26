package com.emsmanagementsystem.controllers;

import com.emsmanagementsystem.models.Dependent;
import com.emsmanagementsystem.models.Employee;
import com.emsmanagementsystem.models.EntityWrapper;
import com.emsmanagementsystem.models.Insurance;
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

    @PostMapping(path = "/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        return emsAppService.addEmployees(employees);
    }

    @PutMapping(path = "/updateEmployeeById/{id}")
    public Employee updateEmployeeById(@PathVariable(value = "id") String id, @RequestBody Employee employee){
        return emsAppService.updateEmployeeById(id, employee);
    }

    @DeleteMapping(path = "/deleteEmployeeById/{id}")
    public void deleteEmployeeById(@PathVariable(value = "id") String id){
        emsAppService.deleteEmployeeById(id);
    }

    @GetMapping(path = "/getEmpWrapperById/{id}")
    public EntityWrapper getNetSalaryById(@PathVariable(value = "id") String id){
        return emsAppService.getEmpWrapperById(id);
    }

    @GetMapping(path = "/getAllInsurances")
    public List<Insurance> getAllInsurances(){
        return emsAppService.getAllInsurances();
    }

    @PostMapping(path = "/addInsurance")
    public List<Insurance> addInsuranceData(@RequestBody List<Insurance> insurances){
        return emsAppService.addInsuranceData(insurances);
    }

    @PutMapping(path = "/updateInsuranceById/{id}")
    public Insurance updateInsuranceById(@PathVariable(value = "id") String id, @RequestBody Insurance insurance){
        return emsAppService.updateInsuranceById(id, insurance);
    }

    @DeleteMapping(path = "/deleteInsuranceById/{id}")
    public void deleteInsuranceById(@PathVariable(value = "id") String id){
        emsAppService.deleteInsuranceById(id);
    }

    @GetMapping(path = "/getAllDependents")
    public List<Dependent> getAllDependents(){
        return emsAppService.getAllDependents();
    }

    @PostMapping(path = "/addDependent")
    public List<Dependent> addDependentData(@RequestBody List<Dependent> dependents){
        return emsAppService.addDependentData(dependents);
    }

    @PutMapping(path = "/updateDependentById/{id}")
    public Dependent updateDependentById(@PathVariable(value = "id") String id, @RequestBody Dependent dependent){
        return emsAppService.updateDependentById(id, dependent);
    }

    @DeleteMapping(path = "/deleteDependentById/{id}")
    public void deleteDependentById(@PathVariable(value = "id") String id){
        emsAppService.deleteDependentById(id);
    }
}
