package com.emsmanagementsystem.services;

import com.emsmanagementsystem.models.*;
import com.emsmanagementsystem.repository.DepartmentRepository;
import com.emsmanagementsystem.repository.DependentRepository;
import com.emsmanagementsystem.repository.InsuranceRepository;
import com.emsmanagementsystem.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionsCreationService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private DependentRepository dependentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Insurance> addInsuranceData(List<Insurance> insurance) {
        return insuranceRepository.saveAll(insurance);
    }

    public List<Salary> addSalaryData(List<Salary> salaries) {
        return salaryRepository.saveAll(salaries);
    }

    public List<Dependent> addDependentData(List<Dependent> dependents) {
        return dependentRepository.saveAll(dependents);
    }

    public List<Department> addDepartmentData(List<Department> departments) {
        return departmentRepository.saveAll(departments);
    }

    public List<Insurance> getAllInsurances() {
        return insuranceRepository.findAll();
    }

    public Insurance updateInsuranceById(String id, Insurance insurance) {
        Optional<Insurance> insuranceDB = insuranceRepository.findById(id);
        if(insuranceDB.isPresent()){
            return insuranceRepository.save(insurance);
        }
        return null;
    }

    public void deleteInsuranceById(String id) {
        Optional<Insurance> insuranceDB = insuranceRepository.findById(id);
        if(insuranceDB.isPresent()){
            insuranceRepository.deleteById(id);
        }
    }

    public List<Dependent> getAllDependents() {
        return dependentRepository.findAll();
    }

    public Dependent updateDependentById(String id, Dependent dependent) {
        Optional<Dependent> dependentDB = dependentRepository.findById(id);
        if(dependentDB.isPresent()){
            return dependentRepository.save(dependent);
        }
        return null;
    }

    public void deleteDependentById(String id) {
        Optional<Dependent> dependentDB = dependentRepository.findById(id);
        if(dependentDB.isPresent()){
            dependentRepository.deleteById(id);
        }
    }
}
