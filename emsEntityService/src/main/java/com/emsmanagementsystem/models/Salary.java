package com.emsmanagementsystem.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "salary")
@Data
public class Salary {
    @Id
    private String id;

    private String employeeId;

    private int basicPay;

    private int mealAllowance;

    private int commuteAllowance;

    private int phoneAllowance;

    private int internetAllowance;

    private int taxPercentage;
}
