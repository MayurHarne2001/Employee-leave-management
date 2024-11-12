package com.example.Employee_Leave.controller;

import com.example.Employee_Leave.Entity.LeaveCategory;
import com.example.Employee_Leave.Service.LeaveCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/leaveCategory")
public class LeaveCategoryController {

    private final LeaveCategoryService leaveCategoryService;

    public LeaveCategoryController(LeaveCategoryService leaveCategoryService) {
        this.leaveCategoryService = leaveCategoryService;
    }

    @PostMapping("/post")
    public ResponseEntity<LeaveCategory> addLeaveCategory(@RequestBody LeaveCategory leaveCategory) {
        return ResponseEntity.status(HttpStatus.CREATED).body(leaveCategoryService.addLeaveCategory(leaveCategory));
    }
}
