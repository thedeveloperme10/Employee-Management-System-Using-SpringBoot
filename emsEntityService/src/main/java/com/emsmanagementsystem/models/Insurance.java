package com.emsmanagementsystem.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "insurance")
@Data
public class Insurance {
    @Id
    private String insuredId;

    private int amountCovered;

    private int premiumPerMonth;
}
