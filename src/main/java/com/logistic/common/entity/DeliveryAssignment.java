package com.logistic.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAssignment {

    private Long id;

    private Item item;

    private User driver;

    private String assignedBy;

    private LocalDateTime assignedDatetime;

    private String status;

    private String remarks;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

}