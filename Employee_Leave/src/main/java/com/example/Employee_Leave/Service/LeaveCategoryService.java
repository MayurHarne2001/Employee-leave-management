package com.example.Employee_Leave.Service;

import com.example.Employee_Leave.Entity.LeaveCategory;
import com.example.Employee_Leave.Repository.LeaveCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class LeaveCategoryService {

    private final LeaveCategoryRepository leaveCategoryRepository;

    public LeaveCategoryService(LeaveCategoryRepository leaveCategoryRepository) {
        this.leaveCategoryRepository = leaveCategoryRepository;
    }

    public LeaveCategory addLeaveCategory(LeaveCategory leaveCategory) {
        return leaveCategoryRepository.save(leaveCategory);
    }
}
