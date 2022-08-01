package com.prowings.service;

import com.prowings.dao.StudentDao;
import com.prowings.dao.StudentDaoImpl;
import com.prowings.model.Student;
import com.prowings.util.ModelToEntity;

public class StudentServiceImpl implements StudentService {

	StudentDao stdDao = new StudentDaoImpl();

	@Override
	public boolean createStudent(Student std) {
		return stdDao.createStudent(ModelToEntity.convertToStudentEntity(std));
		
	}

	@Override
	public Student getStudentByRoll(int roll) {
		return ModelToEntity.convertToStudent(stdDao.getStudentByRoll(roll));
		
	}

	@Override
	public boolean updateStudent(int roll,Student std) {
		// TODO Auto-generated method stub
		return stdDao.updateStudent((roll),ModelToEntity.convertToStudentEntity(std));
	}

	@Override
	public boolean deleteStudent(int roll) {
		
		return stdDao.deleteStudent(roll);
	}

}
