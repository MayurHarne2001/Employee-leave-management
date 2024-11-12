package com.example.Employee_Leave.Service;

import com.example.Employee_Leave.Dto.LeaveSummaryDTO;
import com.example.Employee_Leave.Entity.Employee;
import com.example.Employee_Leave.Entity.Leave;
import com.example.Employee_Leave.Entity.LeaveCategory;
import com.example.Employee_Leave.Repository.EmployeeRepository;
import com.example.Employee_Leave.Repository.LeaveCategoryRepository;
import com.example.Employee_Leave.Repository.LeaveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
@AllArgsConstructor

@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;
    private final EmployeeRepository employeeRepository;
    private final LeaveCategoryRepository leaveCategoryRepository;


    public Leave addLeave(Leave leave) {
        // Check if the employee exists
        Optional<Employee> staffMember = employeeRepository.findById(leave.getEmployee().getId());
        if (!staffMember.isPresent()) {
            throw new IllegalArgumentException("Employee ID " + leave.getEmployee().getId() + " does not exist.");
        }
        leave.setEmployee(staffMember.get());

        // Check if the leave category exists
        Optional<LeaveCategory> leaveCategory = leaveCategoryRepository.findById(leave.getLeaveCategory().getCategoryId());
        if (!leaveCategory.isPresent()) {
            throw new IllegalArgumentException("Leave Category ID " + leave.getLeaveCategory().getCategoryId() + " does not exist.");
        }
        leave.setLeaveCategory(leaveCategory.get());

        // Now save the leave
        return leaveRepository.save(leave);
    }


    public LeaveSummaryDTO getLeaveSummaryForEmployee(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (!employee.isPresent()) {
            return new LeaveSummaryDTO();
        }
        // Retrieve all leaves taken by employee
        List<Leave> leaves = leaveRepository.findByEmployeeId(employeeId);

        Map<String, Map<String, Long>> leaveCountsByCategoryAndDate = leaves.stream()
                .collect(Collectors.groupingBy(
                        leave -> leave.getLeaveCategory().getCategoryName(),
                        Collectors.groupingBy(
                                leave -> leave.getDate().toString(),
                                Collectors.counting()
                        )
                ));


        int totalLeaves = 10;

        int totalLeavesTaken = leaves.size();
        int remainingLeaves = totalLeaves - totalLeavesTaken;
        int excessLeaves = remainingLeaves < 0 ? Math.abs(remainingLeaves) : 0;


        LeaveSummaryDTO leaveSummaryDTO = new LeaveSummaryDTO();
        leaveSummaryDTO.setEmpId(String.valueOf(employee.get().getId()));
        leaveSummaryDTO.setEmpName(employee.get().getName());
        leaveSummaryDTO.setTotalLeaves(totalLeaves);
        leaveSummaryDTO.setLeavesTaken(totalLeavesTaken);
        leaveSummaryDTO.setRemainingLeaves(Math.max(remainingLeaves, 0));
        leaveSummaryDTO.setExcessLeaves(excessLeaves);

        List<LeaveSummaryDTO.LeaveDetail> leaveDetails = new ArrayList<>();

        leaveCountsByCategoryAndDate.forEach((categoryName, dateMap) -> {
            dateMap.forEach((date, count) -> {
                LeaveSummaryDTO.LeaveDetail detail = new LeaveSummaryDTO.LeaveDetail();
                detail.setCategoryName(categoryName);
                detail.setLeaveDate(date);
                detail.setLeavesTaken(count.intValue());
                leaveDetails.add(detail);
            });
        });

        leaveSummaryDTO.setLeaveDetails(leaveDetails);

        return leaveSummaryDTO;
    }
}
