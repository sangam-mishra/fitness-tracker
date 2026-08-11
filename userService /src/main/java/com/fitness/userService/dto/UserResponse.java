package com.fitness.userService.dto;

import com.fitness.userService.model.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Data
public class UserResponse {
        private String id;
        private String userName;
        private String password;
        private String firstName;
        private String lastName;
        private LocalDateTime creation_time;
        private LocalDateTime updatation_time;

}
