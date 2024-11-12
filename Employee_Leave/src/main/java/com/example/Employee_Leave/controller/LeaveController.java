package com.example.Employee_Leave.controller;

import com.example.Employee_Leave.Dto.LeaveSummaryDTO;
import com.example.Employee_Leave.Entity.Leave;
import com.example.Employee_Leave.Service.LeaveService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@AllArgsConstructor
@RestController
@RequestMapping("/api/empLeave")
public class LeaveController {

    private final LeaveService leaveService;


    @PostMapping("/post")
    public ResponseEntity<Leave> addLeave(@RequestBody Leave leave){
        return ResponseEntity.status(HttpStatus.CREATED).body(leaveService.addLeave(leave));
    }

    @GetMapping("/summary/{employeeId}")
    public ResponseEntity<LeaveSummaryDTO> getLeaveSummary(@PathVariable Long employeeId) {
        LeaveSummaryDTO leaveSummary = leaveService.getLeaveSummaryForEmployee(employeeId);
        return ResponseEntity.ok(leaveSummary);
    }
}
