package com.logistic.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Long id;

    private Consignment consignment;

    private String item_id;

    private String status;

    private String currentLocationCode;

    private LocalDateTime createdDate;

    private String createdBy;

    private LocalDateTime updatedDate;

    private String updatedBy;
}
