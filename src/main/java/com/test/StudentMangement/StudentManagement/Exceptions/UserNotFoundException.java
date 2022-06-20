package com.test.StudentMangement.StudentManagement.Exceptions;

import java.util.function.Supplier;

public class UserNotFoundException extends Exception {
    int id;

    public UserNotFoundException(int id) {
        super("Student not found");
        this.id = id;
    }
}

