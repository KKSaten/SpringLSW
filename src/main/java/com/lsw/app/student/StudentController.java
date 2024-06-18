package com.lsw.app.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/student/list")
	public String getList(HttpServletRequest request) {
		
		List<StudentDTO> ar = studentService.getStudents();
		request.setAttribute("list", ar);

		//redirect:url
		return "/student/list";
	}
	
	@RequestMapping("/student/detail")
	public String getDetail(HttpServletRequest request) {
		
		String num = request.getParameter("num");
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setNum(Integer.parseInt(num));
		studentDTO = studentService.getDetail(studentDTO);

		request.setAttribute("std", studentDTO);
		
		return "/student/detail";
	}
	
	
	@RequestMapping(value = "/student/add", method = RequestMethod.GET)
	public String add(HttpServletRequest request) {
		return "/student/add";
		
	}
	
	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	public String add2(HttpServletRequest request) {
		
		System.out.println("학생 등록 데이터를 꺼내야 함");
		StudentDTO student = new StudentDTO();
		String name = request.getParameter("name");
		int num = Integer.parseInt(request.getParameter("num"));
		double avg = Double.parseDouble(request.getParameter("avg"));
		student.setName(name);
		student.setNum(num);
		student.setAvg(avg);
		
		System.out.println(request.getParameter("ch"));
		System.out.println(request.getParameter("mobile"));
		String[] sports = request.getParameterValues("sports");
		
		for(String s: sports) {
			System.out.println(s);
		}
			
		return "redirect:/student/list";
	}
	
	
	
	@RequestMapping("/student/delete")
	public String delete(HttpServletRequest request) {
		
		StudentDTO studentDTO = new StudentDTO();
		String num = request.getParameter("num");
		studentDTO.setNum(Integer.parseInt(num));
		List<StudentDTO> list = studentService.delete(studentDTO);

		//redirect:url
		return "/student/delete";
	}
	
	
	
	
}
