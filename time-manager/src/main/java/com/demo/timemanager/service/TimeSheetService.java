package com.demo.timemanager.service;

import com.demo.timemanager.dto.TimeSheetDto;
import com.demo.timemanager.entity.TimeSheet;
import com.demo.timemanager.repository.TimeSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class TimeSheetService {

    /* @Autowired
     private TimeSheetMapper timeSheetMapper;*/

     @Autowired
     private TimeSheetRepository timeSheetRepository;



    public List<TimeSheet> findAllTimeSheet() {
        return timeSheetRepository.findAll();
    }

    public TimeSheet save(TimeSheet timeSheet) {
        // Save the entity to the repository
        return timeSheetRepository.save(timeSheet);
    }


    public TimeSheet findTimeSheetById(String id) {
        return timeSheetRepository.findById(id).orElse(null);
    }
}
