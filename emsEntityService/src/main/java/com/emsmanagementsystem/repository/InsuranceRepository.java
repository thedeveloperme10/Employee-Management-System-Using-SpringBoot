package com.emsmanagementsystem.repository;

import com.emsmanagementsystem.models.Insurance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends MongoRepository<Insurance, String> {
}
