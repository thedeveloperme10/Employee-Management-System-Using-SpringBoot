package com.emsmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
@Data
@JsonIgnoreProperties({"_id", "_class"})
public class Employee {
    @Id
    @JsonAlias("_id")
    private String employeeId;

    private String employeeName;

    private int age;

    private String gender;

    private String phoneNumber;

    private String departmentId;
}
