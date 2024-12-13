package com.example.BookMyShow.repository;

import com.example.BookMyShow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User , Integer> {
    User findByEmail(String email);
    User findByIdAndIsDeleted(int userId , boolean isDeleted);
}