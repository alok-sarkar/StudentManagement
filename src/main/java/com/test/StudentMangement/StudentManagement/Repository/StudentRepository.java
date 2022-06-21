package com.test.StudentMangement.StudentManagement.Repository;

import com.test.StudentMangement.StudentManagement.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Override
    Optional<Student> findById(Integer id);

    Optional<Student> findByEmail(String email);
}
