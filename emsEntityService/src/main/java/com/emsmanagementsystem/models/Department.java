package com.emsmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "department")
@Data
@JsonIgnoreProperties({"_id", "_class"})
public class Department {
    private String departmentId;

    private String departmentName;

    private int size;
}
