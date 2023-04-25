package com.emsmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dependent")
@Data
@JsonIgnoreProperties({"_id", "_class"})
public class Dependent {
    private String dependentId;

    private String employeeId;

    private String dependentName;

    private int dependentAge;

    private String dependentGender;

    private String relationship;
}
