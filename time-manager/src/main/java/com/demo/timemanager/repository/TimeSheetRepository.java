package com.demo.timemanager.repository;
import com.demo.timemanager.entity.TimeSheet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSheetRepository extends MongoRepository<TimeSheet, String> {
}
