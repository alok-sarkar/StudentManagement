package com.test.StudentMangement.StudentManagement.Exceptions;

public class StudentNotFoundException extends RuntimeException {
    int id;
    String username;

    public StudentNotFoundException(int id) {
        super("Student not found");
        this.id = id;
    }

    public StudentNotFoundException(String username) {
        super("Student not found");
        this.username = username;
    }
}


