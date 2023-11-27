package com.sbp.operation.UserService.UserService.repositories;

import com.sbp.operation.UserService.UserService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceRepository extends JpaRepository<User, String> {
}
