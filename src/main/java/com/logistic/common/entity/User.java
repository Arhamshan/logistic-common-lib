package com.logistic.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
        private Long id;

        private String username;

        private String password;

        private String role;

        private String status;

        private LocalDateTime createdDate;

        private String createdBy;

        private LocalDateTime updatedDate;

        private String updatedBy;
}
