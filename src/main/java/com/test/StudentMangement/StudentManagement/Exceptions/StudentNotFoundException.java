package com.test.StudentMangement.StudentManagement.Exceptions;

public class StudentNotFoundException extends RuntimeException {
    int id;

    public StudentNotFoundException(int id) {
        super("Student not found");
        this.id = id;
    }
}

