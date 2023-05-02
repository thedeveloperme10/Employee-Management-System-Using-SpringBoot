package com.emsmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dependent")
@Data
@JsonIgnoreProperties({"_id", "_class"})
public class Dependent implements Comparable<Dependent> {
    @Id
    @JsonAlias("_id")
    private String dependentId;

    private String employeeId;

    private String dependentName;

    private int dependentAge;

    private String dependentGender;

    private String relationship;

    @Override public int compareTo(Dependent compareDependent) {
        String compareDependentId
                = ((Dependent)compareDependent).getDependentId();
        return this.dependentId.compareTo(compareDependentId);
    }
}
