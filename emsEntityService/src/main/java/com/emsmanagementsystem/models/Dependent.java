package com.emsmanagementsystem.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dependent")
@Data
public class Dependent {
    @Id
    private String id;

    private String employeeId;

    private int age;

    private String gender;

    private String relationship;
}
