package com.emsmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "insurance")
@Data
@JsonIgnoreProperties({"_id", "_class"})
public class Insurance implements Comparable<Insurance> {
    @Id
    @JsonAlias("_id")
    private String insuredId;

    private int amountCovered;

    private int premiumPerMonth;

    @Override public int compareTo(Insurance compareInsurance) {
        String compareInsuredId
                = ((Insurance)compareInsurance).getInsuredId();
        return this.insuredId.compareTo(compareInsuredId);
    }
}
