package com.emsmanagementsystem.services;

import com.emsmanagementsystem.models.Employee;
import com.emsmanagementsystem.models.EntityWrapper;
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

    @SneakyThrows
    public Employee getEmployeeById(String id) {
        return httpUtil.get(id);
    }

    @SneakyThrows
    public Employee updateEmployeeById(String id, Employee employee) {
        return httpUtil.put(id, employee);
    }

    @SneakyThrows
    public void deleteEmployeeById(String id) {
        httpUtil.delete(id);
    }

    @SneakyThrows
    public EntityWrapper getEmpWrapperById(String id) {
        return httpUtil.getEntity(id);
    }
}
