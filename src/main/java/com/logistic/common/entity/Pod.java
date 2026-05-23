package com.logistic.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pod {

    private Long id;

    private Item item;

    private String receivedBy;

    private String receiverContact;

    private String remarks;

    private String podPath;

    private LocalDateTime deliveredAt;

    private String deliveredBy;

    private LocalDateTime createdDate;

    private String createdBy;

    private LocalDateTime updatedDate;

    private String updatedBy;
}