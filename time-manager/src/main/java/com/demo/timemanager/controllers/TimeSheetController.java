package com.demo.timemanager.controllers;

import com.demo.timemanager.dto.TimeSheetDto;
import com.demo.timemanager.entity.TimeSheet;
import com.demo.timemanager.service.TimeSheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeSheetController {

    @Autowired
    private TimeSheetService timeSheetService;



    @PostMapping
    public ResponseEntity<TimeSheet> addTimeSheet(@RequestBody TimeSheet timeSheet){
        return ResponseEntity.ok(timeSheetService.save(timeSheet));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Object> getTimeSheet(){
        var transactions = timeSheetService.findAllTimeSheet();
        return ResponseEntity.ok("works");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Object> getTimeSheetById(@PathVariable String id) {
        // Call the service to fetch the TimeSheet by ID
        TimeSheet timeSheet = timeSheetService.findTimeSheetById(id);
        return ResponseEntity.ok("Works");
    }

}
