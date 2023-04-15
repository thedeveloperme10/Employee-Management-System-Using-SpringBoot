package com.emsmanagementsystem.services;

import com.emsmanagementsystem.models.Employee;
import com.emsmanagementsystem.utils.HttpUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EMSAppService {

    @Autowired
    private HttpUtil httpUtil;

    @SneakyThrows
    public List<Employee> getAllEmployees() {
        return httpUtil.getList();
    }

    @SneakyThrows
    public Employee addEmployee(Employee employee) {
        return httpUtil.add(employee);
    }
}
