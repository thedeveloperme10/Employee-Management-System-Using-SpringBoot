package com.emsmanagementsystem.repository;

import com.emsmanagementsystem.models.Dependent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependentRepository extends MongoRepository<Dependent, String> {
}
