package com.example.Employee_Leave.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveSummaryDTO {
    private String empId;
    private String empName;
    private int totalLeaves;
    private int leavesTaken;
    private int remainingLeaves;
    private int excessLeaves;
    private List<LeaveDetail> leaveDetails; // List to hold detailed leave data


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LeaveDetail {
        private String categoryName;
        private String leaveDate; // Store the leave date as a string to match the date format
        private int leavesTaken;
    }


}
