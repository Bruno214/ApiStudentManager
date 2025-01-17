package com.estudo.mongo.Api_StudentManager.repository;

import com.estudo.mongo.Api_StudentManager.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
