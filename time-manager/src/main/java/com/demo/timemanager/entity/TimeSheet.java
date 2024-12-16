package com.demo.timemanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.time.LocalTime;
import java.util.UUID;
@Document(collection = "time")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSheet {

    private String timeId;

    private String date;

    private String startTime;

    private String endTime;

    private String project;

    private String task;

    private Boolean overTime;

}
