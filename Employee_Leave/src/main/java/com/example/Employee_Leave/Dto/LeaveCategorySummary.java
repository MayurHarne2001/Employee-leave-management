package com.example.Employee_Leave.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveCategorySummary {
    private String categoryName;
    private int leavesTaken;
    private String date;
}
