package com.logistic.common.entity;

import com.logistic.common.enums.LocationType;
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

    private LocationType type;

    private String city;

    private String country;

    private String latitude;

    private String longitude;

    private LocalDateTime createdDate;

    private String createdBy;

    private LocalDateTime updatedDate;

    private String updatedBy;
}
