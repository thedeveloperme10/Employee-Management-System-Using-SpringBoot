package com.emsmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "salary")
@Data
@JsonIgnoreProperties({"_id", "_class"})
public class Salary {
    @Id
    private String salaryId;

    private String employeeId;

    private int basicPay;

    private int mealAllowance;

    private int commuteAllowance;

    private int phoneAllowance;

    private int internetAllowance;

    private int taxPercentage;
}
