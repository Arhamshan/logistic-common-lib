package com.logistic.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private Long id;

    private String locationCode;

    private String name;

    private String type;

    private String city;

    private String county;

    private String latitude;

    private String longitude;

    private LocalDateTime createdDate;

    private String createdBy;

    private LocalDateTime updatedDate;

    private String updatedBy;
}
