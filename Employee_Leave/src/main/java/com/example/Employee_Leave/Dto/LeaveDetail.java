package com.example.Employee_Leave.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveDetail {
    private String categoryName;
    private String leaveDate; // Store the leave date as a string to match the date format
    private int leavesTaken;
}
