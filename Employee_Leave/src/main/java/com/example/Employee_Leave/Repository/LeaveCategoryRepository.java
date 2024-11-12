package com.example.Employee_Leave.Repository;

import com.example.Employee_Leave.Entity.LeaveCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveCategoryRepository extends JpaRepository<LeaveCategory, Long> {
}
