package com.logistic.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consignment {

    private Long id;

    private String consignmentId;

    private Contact senderContact;

    private Contact destinationContact;

    private String status;

    private Float weight;

    private Float height;

    private Float length;

    private Float width;

    private LocalDateTime createdDate;

    private String createdBy;

    private LocalDateTime updatedDate;

    private String updatedBy;
}
