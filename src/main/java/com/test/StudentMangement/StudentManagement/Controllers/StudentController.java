package com.test.StudentMangement.StudentManagement.Controllers;

import com.test.StudentMangement.StudentManagement.Models.Student;
import com.test.StudentMangement.StudentManagement.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int Id){
        return new ResponseEntity<Student>(studentService.getStudentById(Id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id,@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student,id),HttpStatus.OK );
    }
    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student Data deleted Successfully",HttpStatus.OK);
    }
}
