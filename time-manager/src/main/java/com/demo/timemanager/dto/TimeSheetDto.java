package com.demo.timemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSheetDto {
    private String timeId;

    private String date;

    private String startTime;

    private String endTime;

    private String project;

    private String task;

    private Boolean overTime;
}
