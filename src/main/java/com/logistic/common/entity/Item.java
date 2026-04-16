package com.logistic.common.entity;

import com.logistic.common.enums.ItemStatus;
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

    private String itemId;

    private ItemStatus status;

    private String currentLocationCode;

    private Float weight;

    private Float height;

    private Float length;

    private Float width;

    private LocalDateTime createdDate;

    private String createdBy;

    private LocalDateTime updatedDate;

    private String updatedBy;
}
