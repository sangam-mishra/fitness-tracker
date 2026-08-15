package com.fitness.userService.repository;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fitness.userService.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByuserName(@NotBlank(message = "Email is required") String userName);
}
