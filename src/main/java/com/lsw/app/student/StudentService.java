package com.lsw.app.student;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lsw.app.student.StudentDAO;
import com.lsw.app.student.StudentDTO;

@Service
public class StudentService {
	
	private StudentDAO studentDAO;
	public StudentService() {
		studentDAO = new StudentDAO();	
	}
	
	//list 가져오기
	public List<StudentDTO> getStudents() {
		List<StudentDTO> ar = null;
		try {
			ar = studentDAO.getStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ar;
	}
	
	//detail 가져오기
	public StudentDTO getDetail(StudentDTO studentDTO) {
		try {
			studentDTO = studentDAO.getDetail(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			studentDTO = null;
		}
		
		return studentDTO;
	}
	
	//delete
	public List<StudentDTO> delete(StudentDTO studentDTO) {
		List<StudentDTO> ar = null;
		try {
			studentDAO.delete(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
	
	
	
	
	

}
