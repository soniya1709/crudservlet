package com.prowings.dao;

import com.prowings.entities.StudentEntity;

public interface StudentDao {
	public boolean createStudent(StudentEntity std);
	public StudentEntity getStudentByRoll(int roll);
	public boolean updateStudent(int roll,StudentEntity std);
	public boolean deleteStudent(int roll);

}
