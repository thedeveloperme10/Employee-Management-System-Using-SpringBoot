package com.emsmanagementsystem.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
@Data
public class Employee {
    @Id
    private String id;

    private String name;

    private int age;

    private String gender;

    private String phoneNumber;

    private int departmentId;
}
