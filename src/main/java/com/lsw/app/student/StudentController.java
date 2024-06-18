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
		studentDTO.setNum(Long.parseLong(num));
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
		
//		long num = Long.parseLong(request.getParameter("num"));
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		int total = Integer.parseInt(request.getParameter("total"));
		double avg = Double.parseDouble(request.getParameter("avg"));
				
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setName(name);
		studentDTO.setKor(kor);
		studentDTO.setEng(eng);
		studentDTO.setMath(math);
		studentDTO.setTotal(total);
		studentDTO.setAvg(avg);
		studentService.add(studentDTO);
		
		
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
