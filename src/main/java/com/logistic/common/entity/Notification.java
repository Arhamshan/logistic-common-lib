package com.logistic.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    private Long id;

    private Long consId;

    private String eventCode;

    private String recipientEmail;

    private String recipientPhone;

    private String subject;

    private String message;

    private String status;

    private LocalDateTime sentDate;

    private LocalDateTime createdDate;

    private String createdBy;

    private LocalDateTime updatedDate;

    private String updatedBy;
}