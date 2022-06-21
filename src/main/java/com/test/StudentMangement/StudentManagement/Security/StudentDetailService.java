package com.test.StudentMangement.StudentManagement.Security;

import com.test.StudentMangement.StudentManagement.Exceptions.StudentNotFoundException;
import com.test.StudentMangement.StudentManagement.Models.Student;
import com.test.StudentMangement.StudentManagement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class StudentDetailService implements UserDetailsService {
    @Autowired
    private StudentRepository sRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student= sRepo.findByEmail(username).orElseThrow(()-> new StudentNotFoundException(username));
        return student;
    }
}
