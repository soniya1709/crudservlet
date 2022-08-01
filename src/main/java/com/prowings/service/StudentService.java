package com.prowings.service;

import com.prowings.model.Student;

public interface StudentService {
public boolean createStudent(Student std);
public Student getStudentByRoll(int roll);
public boolean updateStudent(int roll,Student std);
public boolean deleteStudent(int roll);
}