package com.logistic.common.entity;

import com.logistic.common.enums.Role;
import com.logistic.common.enums.Status;
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

        private Role role;

        private Status status;

        private LocalDateTime createdDate;

        private String createdBy;

        private LocalDateTime updatedDate;

        private String updatedBy;

        // Transactional Attribute
        private String token;
}
