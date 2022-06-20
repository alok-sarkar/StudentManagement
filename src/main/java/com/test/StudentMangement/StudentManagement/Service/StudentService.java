package com.test.StudentMangement.StudentManagement.Service;

import com.test.StudentMangement.StudentManagement.Models.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    Student getStudentById(int id);
    Student updateStudent(Student student, int id);
    List<Student> getAllStudents();
    void deleteStudent(int id);
}
