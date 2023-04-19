package com.emsmanagementsystem.services;

import com.emsmanagementsystem.models.Department;
import com.emsmanagementsystem.models.Dependent;
import com.emsmanagementsystem.models.Insurance;
import com.emsmanagementsystem.models.Salary;
import com.emsmanagementsystem.repository.DepartmentRepository;
import com.emsmanagementsystem.repository.DependentRepository;
import com.emsmanagementsystem.repository.InsuranceRepository;
import com.emsmanagementsystem.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
