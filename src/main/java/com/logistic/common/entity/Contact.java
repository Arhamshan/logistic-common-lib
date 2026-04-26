package com.logistic.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String addressLine1;

    private String addressLine2;

    private String state;

    private String suburb;

    private String postcode;

    private String country;

    private String latitude;

    private String longitude;

    private LocalDateTime createdDate;

    private String createdBy;

    private LocalDateTime updatedDate;

    private String updatedBy;

}
