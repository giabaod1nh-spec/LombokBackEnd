package com.simple.student_trainning_points.repository;

import com.simple.student_trainning_points.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , String> {
}
