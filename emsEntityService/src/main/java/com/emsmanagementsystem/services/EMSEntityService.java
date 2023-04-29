package com.emsmanagementsystem.services;

import com.emsmanagementsystem.models.*;
import com.emsmanagementsystem.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EMSEntityService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "employeeId"));
    }

    public List<Employee> addEmployee(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public Employee getEmployeeById(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    public Employee updateEmployeeById(String id, Employee employee) {
        Optional<Employee> employeeDB = employeeRepository.findById(id);
        if(employeeDB.isPresent()){
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployeeById(String id) {
        Optional<Employee> employeeDB = employeeRepository.findById(id);
        if(employeeDB.isPresent()){
            employeeRepository.deleteById(id);
        }
    }

    @SneakyThrows
    public EntityWrapper getEmpWrapperById(String id) {
        String uri = "mongodb://localhost:27017";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("test");

        MongoCollection<org.bson.Document> employeeCollection = database.getCollection("employee");
        MongoCollection<org.bson.Document> salaryCollection = database.getCollection("salary");
        MongoCollection<org.bson.Document> dependentCollection = database.getCollection("dependent");
        MongoCollection<org.bson.Document> departmentCollection = database.getCollection("department");
        MongoCollection<org.bson.Document> insuranceCollection = database.getCollection("insurance");

        ObjectMapper objectMapper = new ObjectMapper();
        EntityWrapper ew = new EntityWrapper();
        List<Employee> employeeWrapperList = new ArrayList<>();
        List<Salary> salaryWrapperList = new ArrayList<>();
        List<Department> departmentWrapperList = new ArrayList<>();
        List<Dependent> dependentWrapperList = new ArrayList<>();
        List<Insurance> insuranceWrapperList = new ArrayList<>();

        try (MongoCursor<org.bson.Document> employeeCursor = employeeCollection.find().iterator()) {
            MongoCursor<org.bson.Document> salaryCursor = salaryCollection.find().iterator();
            MongoCursor<org.bson.Document> dependentCursor = dependentCollection.find().iterator();
            MongoCursor<org.bson.Document> departmentCursor = departmentCollection.find().iterator();
            MongoCursor<org.bson.Document> insuranceCursor = insuranceCollection.find().iterator();
            while (employeeCursor.hasNext()) {
                String jsonString = employeeCursor.next().toJson();
                employeeWrapperList.add(objectMapper.readValue(jsonString, Employee.class));
            }
            for (Employee e : employeeWrapperList) {
                if (e.getEmployeeId().equals(id)) {
                    ew.setEmployeeId(e.getEmployeeId());
                    ew.setEmployeeName(e.getEmployeeName());
                    ew.setAge(e.getAge());
                    ew.setGender(e.getGender());
                    ew.setPhoneNumber(e.getPhoneNumber());
                    ew.setDepartmentId(e.getDepartmentId());
                }
            }
            if (ew.getEmployeeId() != null) {
                while (salaryCursor.hasNext()) {
                    String jsonString = salaryCursor.next().toJson();
                    salaryWrapperList.add(objectMapper.readValue(jsonString, Salary.class));
                }
                for (Salary sw : salaryWrapperList) {
                    if (sw.getEmployeeId().equals(ew.getEmployeeId())) {
                        ew.setBasicPay(sw.getBasicPay());
                        ew.setCommuteAllowance(sw.getCommuteAllowance());
                        ew.setInternetAllowance(sw.getInternetAllowance());
                        ew.setMealAllowance(sw.getMealAllowance());
                        ew.setPhoneAllowance(sw.getPhoneAllowance());
                        ew.setTaxPercentage(sw.getTaxPercentage());
                    }
                }

                List<Dependent> dependents = new ArrayList<>();
                while (dependentCursor.hasNext()) {
                    String jsonString = dependentCursor.next().toJson();
                    dependentWrapperList.add(objectMapper.readValue(jsonString, Dependent.class));
                }
                for (Dependent dp : dependentWrapperList) {
                    if (dp.getEmployeeId().equals(ew.getEmployeeId())) {
                        Dependent dependent = new Dependent();
                        dependent.setEmployeeId(ew.getEmployeeId());
                        dependent.setDependentId(dp.getDependentId());
                        dependent.setDependentName(dp.getDependentName());
                        dependent.setRelationship(dp.getRelationship());
                        dependent.setDependentAge(dp.getDependentAge());
                        dependent.setDependentGender(dp.getDependentGender());
                        dependents.add(dependent);
                    }
                }
                ew.setDependents(dependents);

                while (departmentCursor.hasNext()) {
                    String jsonString = departmentCursor.next().toJson();
                    departmentWrapperList.add(objectMapper.readValue(jsonString, Department.class));
                }
                for (Department dp : departmentWrapperList) {
                    if (dp.getDepartmentId().equals(ew.getDepartmentId())) {
                        ew.setDepartmentName(dp.getDepartmentName());
                        ew.setSize(dp.getSize());
                    }
                }

                List<Insurance> insurances = new ArrayList<>();
                while (insuranceCursor.hasNext()) {
                    String jsonString = insuranceCursor.next().toJson();
                    insuranceWrapperList.add(objectMapper.readValue(jsonString, Insurance.class));
                }
                for (Insurance in : insuranceWrapperList) {
                    if (in.getInsuredId().equals(ew.getEmployeeId())) {
                        Insurance insurance = new Insurance();
                        insurance.setInsuredId(in.getInsuredId());
                        insurance.setAmountCovered(in.getAmountCovered());
                        insurance.setPremiumPerMonth(in.getPremiumPerMonth());
                        insurances.add(insurance);
                    }
                    for(Dependent dp: dependents){
                        if(in.getInsuredId().equals(dp.getDependentId())){
                            Insurance insurance = new Insurance();
                            insurance.setInsuredId(in.getInsuredId());
                            insurance.setAmountCovered(in.getAmountCovered());
                            insurance.setPremiumPerMonth(in.getPremiumPerMonth());
                            insurances.add(insurance);
                        }
                    }
                }
                ew.setInsurancePolicies(insurances);
                int premiumPerMonth = 0, netSalary = 0;
                for(Insurance insurance: insurances) {
                    premiumPerMonth += insurance.getPremiumPerMonth();
                }
                netSalary += ew.getBasicPay() + ew.getInternetAllowance() + ew.getCommuteAllowance() + ew.getMealAllowance() + ew.getPhoneAllowance();
                netSalary -= premiumPerMonth;
                netSalary = Integer.parseInt(String.valueOf(netSalary * (100 - ew.getTaxPercentage()) / 100));
                netSalary *= 12;
                ew.setNetSalary(netSalary);
            }
        }
        List<DepartmentNetExpenditure> departmentNetExpenditures = calculateNetExpenditure(employeeWrapperList, departmentWrapperList, dependentWrapperList, insuranceWrapperList, salaryWrapperList);
        ew.setDepartmentNetExpenditures(departmentNetExpenditures);
        return ew;
    }

    private List<DepartmentNetExpenditure> calculateNetExpenditure(List<Employee> employees, List<Department> departments, List<Dependent> dependents, List<Insurance> insurances, List<Salary> salaries) {
        List<DepartmentNetExpenditure> departmentNetExpenditures = new ArrayList<>();
        for(Department department: departments){
            DepartmentNetExpenditure departmentNetExpenditure = new DepartmentNetExpenditure();
            int netExpenditure = 0;
            departmentNetExpenditure.setDepartmentId(department.getDepartmentId());
            departmentNetExpenditure.setDepartmentName(department.getDepartmentName());
            departmentNetExpenditure.setSize(department.getSize());

            for(Employee employee: employees){
                if(employee.getDepartmentId().equals(department.getDepartmentId())){
                    String employeeId = employee.getEmployeeId();
                    for(Salary salary: salaries){
                        if(salary.getEmployeeId().equals(employeeId)){
                            netExpenditure += salary.getBasicPay() + salary.getCommuteAllowance() + salary.getMealAllowance() + salary.getPhoneAllowance() + salary.getInternetAllowance();
                        }
                    }
                    String dependentId;
                    for(Dependent dependent: dependents){
                        if(dependent.getEmployeeId().equals(employeeId)){
                            dependentId = dependent.getDependentId();

                            for(Insurance insurance: insurances){
                                if(insurance.getInsuredId().equals(dependentId)){
                                    netExpenditure += insurance.getPremiumPerMonth();
                                }
                                if(insurance.getInsuredId().equals(employeeId)){
                                    netExpenditure += insurance.getPremiumPerMonth();
                                }
                            }
                        }
                    }
                }
            }
            netExpenditure *= 12;
            departmentNetExpenditure.setNetExpenditure(netExpenditure);
            departmentNetExpenditures.add(departmentNetExpenditure);
        }
        return departmentNetExpenditures;
    }
}