package com.example.Employee_Leave.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EmployeeID", referencedColumnName = "id") // Reference to StaffMember entity
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LEAVE_CATEGORY_ID", referencedColumnName = "CATEGORY_ID") // Reference to LeaveCategory entity
    private LeaveCategory leaveCategory;

    @Column(name = "LEAVE_DATE")
    private Date date;
}
