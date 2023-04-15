package com.emsmanagementsystem.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "department")
@Data
public class Department {
    @Id
    private String id;

    private String name;

    private int size;
}
