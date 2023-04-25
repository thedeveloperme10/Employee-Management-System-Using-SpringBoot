package com.emsmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties({ "_class" })
public class EntityWrapper {
    @JsonAlias("employeeId")
    private String employeeId;

    private String employeeName;

    private int age;

    private String gender;

    private String phoneNumber;

    private int size;

    private String departmentId;

    private String departmentName;

    private int basicPay;

    private int mealAllowance;

    private int commuteAllowance;

    private int phoneAllowance;

    private int internetAllowance;

    private int taxPercentage;

    private int netSalary;

    private List<Dependent> dependents;

    private List<Insurance> insurancePolicies;

    private List<DepartmentNetExpenditure> departmentNetExpenditures;
}