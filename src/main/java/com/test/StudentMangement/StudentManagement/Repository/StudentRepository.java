package com.test.StudentMangement.StudentManagement.Repository;

import com.test.StudentMangement.StudentManagement.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
