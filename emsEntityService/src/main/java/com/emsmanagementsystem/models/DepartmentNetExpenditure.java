package com.emsmanagementsystem.models;

import lombok.Data;

@Data
public class DepartmentNetExpenditure {
    private String departmentId;

    private String departmentName;

    private int size;

    private int netExpenditure;
}
