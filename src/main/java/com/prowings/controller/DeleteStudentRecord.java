package com.prowings.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prowings.model.Student;
import com.prowings.service.StudentService;
import com.prowings.service.StudentServiceImpl;

public class DeleteStudentRecord extends HttpServlet {
	StudentService service=new StudentServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		Student model = new Student();
//		model=service.getStudentByRoll(Integer.parseInt(req.getParameter("roll")));
		PrintWriter out = resp.getWriter();
		if(service.deleteStudent(Integer.parseInt(req.getParameter("roll")))){
		out.println("Record delete successfully");
		}
		else {
		out.println("unable to delete record");
		}
}
}