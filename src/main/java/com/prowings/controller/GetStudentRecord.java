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

public class GetStudentRecord extends HttpServlet{
	StudentService service = new StudentServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student model = new Student();
		model=service.getStudentByRoll(Integer.parseInt(req.getParameter("roll")));
		PrintWriter out = resp.getWriter();
	if(model!=null) {
		out.println("Student Details=" +"roll="+model.getRoll() +" "+"Name="+model.getName() +" " +"Address="+model.getAddress());
	}
	else
	{
		out.println("unable to fetch record");
	}
		
	}

}
