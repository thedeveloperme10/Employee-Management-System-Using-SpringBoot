package com.emsmanagementsystem.services;

import com.emsmanagementsystem.models.Dependent;
import com.emsmanagementsystem.models.Employee;
import com.emsmanagementsystem.models.EntityWrapper;
import com.emsmanagementsystem.models.Insurance;
import com.emsmanagementsystem.utils.HttpUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EMSAppService {

    @Autowired
    private HttpUtil httpUtil;

    @SneakyThrows
    public List<Employee> getAllEmployees() {
        return httpUtil.getList();
    }

    @SneakyThrows
    public List<Employee> addEmployees(List<Employee> employees) {
        return httpUtil.add(employees);
    }

    @SneakyThrows
    public Employee getEmployeeById(String id) {
        return httpUtil.get(id);
    }

    @SneakyThrows
    public Employee updateEmployeeById(String id, Employee employee) {
        return httpUtil.updateEmployee(id, employee);
    }

    @SneakyThrows
    public void deleteEmployeeById(String id) {
        String collection = "employee";
        httpUtil.delete(id, collection);
    }

    @SneakyThrows
    public EntityWrapper getEmpWrapperById(String id) {
        return httpUtil.getEntity(id);
    }

    @SneakyThrows
    public List<Insurance> getAllInsurances() {
        return httpUtil.getInsurancesList();
    }

    @SneakyThrows
    public List<Insurance> addInsuranceData(List<Insurance> insurances) {
        return httpUtil.addInsurance(insurances);
    }

    @SneakyThrows
    public Insurance updateInsuranceById(String id, Insurance insurance) {
        return httpUtil.updateInsurance(id, insurance);
    }

    @SneakyThrows
    public void deleteInsuranceById(String id) {
        String collection = "insurance";
        httpUtil.delete(id, collection);
    }

    @SneakyThrows
    public List<Dependent> getAllDependents() {
        return httpUtil.getAllDependentsList();
    }

    @SneakyThrows
    public List<Dependent> addDependentData(List<Dependent> dependents) {
        return httpUtil.addDependent(dependents);
    }

    @SneakyThrows
    public Dependent updateDependentById(String id, Dependent insurance) {
        return httpUtil.updateDependent(id, insurance);
    }

    @SneakyThrows
    public void deleteDependentById(String id) {
        String collection = "dependent";
        httpUtil.delete(id, collection);
    }
}
