package com.emsmanagementsystem.repository;

import com.emsmanagementsystem.models.Salary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends MongoRepository<Salary, String> {
}
