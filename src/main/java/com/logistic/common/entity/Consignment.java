package com.logistic.common.entity;

import com.logistic.common.enums.ConsignmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consignment {

    private Long id;

    private String consignmentId;

    private Contact senderContact;

    private Contact destinationContact;

    private ConsignmentStatus status;

    private LocalDateTime createdDate;

    private String createdBy;

    private LocalDateTime updatedDate;

    private String updatedBy;

    // Transactional
    private List<Item> items;

    public Consignment(Long consId, String consignmentId) {
        this.id = consId;
        this.consignmentId = consignmentId;
    }

}
