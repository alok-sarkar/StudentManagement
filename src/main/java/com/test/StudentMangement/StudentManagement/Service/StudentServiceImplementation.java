package com.test.StudentMangement.StudentManagement.Service;

import com.test.StudentMangement.StudentManagement.Exceptions.StudentNotFoundException;
import com.test.StudentMangement.StudentManagement.Models.Student;
import com.test.StudentMangement.StudentManagement.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImplementation implements StudentService{
    private StudentRepository studentRepository;

    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
    }

    @Override
    public Student updateStudent(Student student, int id) {
        Student existingStudent=studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
        existingStudent.setEmail(student.getEmail());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        studentRepository.save(existingStudent);
        return existingStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));

        studentRepository.deleteById(id);
    }
}
