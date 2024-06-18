package com.lsw.app.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsw.app.student.StudentDTO;

@Repository
public class StudentDAO {
	
	public List<StudentDTO> getStudents() throws Exception{
		
		File file = new File("C:\\study\\student.txt");
		ArrayList<StudentDTO> ar = new ArrayList<StudentDTO>();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			String s = br.readLine();
			
			if(s == null) {
				break;
			}
			
			StudentDTO studentDTO = new StudentDTO();
			String[] sp = s.split(",");
			studentDTO.setNum(Integer.parseInt(sp[0].trim()));
			studentDTO.setName(sp[1].trim());
			studentDTO.setKor(Integer.parseInt(sp[2].trim()));
			studentDTO.setEng(Integer.parseInt(sp[3].trim()));
			studentDTO.setMath(Integer.parseInt(sp[4].trim()));
			studentDTO.setTotal(Integer.parseInt(sp[5].trim()));
			studentDTO.setAvg(Double.parseDouble(sp[6].trim()));
			ar.add(studentDTO);	
		}//while문 끝
		
		br.close();
		fr.close();
		
		return ar;	
	} //getStudent() 끝


	public StudentDTO getDetail(StudentDTO studentDTO) throws Exception {
		List<StudentDTO> ar = this.getStudents();
		
		StudentDTO result = null;
		
		for(StudentDTO s : ar) {
			if(s.getNum() == studentDTO.getNum()) {
				result = s;
				break;
			}	
		}
		
		
		return result;
	}
	
	
	
	public void delete(StudentDTO studentDTO) throws Exception{
		
		List<StudentDTO> list = this.getStudents();
		for (StudentDTO dto : list) {
			if (dto.getNum() == studentDTO.getNum()) {
				list.remove(dto);
				break;
			}
		}

		File file = new File("C:\\study", "student.txt");
		FileWriter fw = new FileWriter(file, false); 

		for (StudentDTO dto : list) {
			StringBuffer stringBuffer = new StringBuffer(); // 반복문 돌떄마다 새로운 객체 생성
			stringBuffer.append(dto.getNum()); // 넘버 첫번쨰로 나오게 하고
			stringBuffer.append("-");
			stringBuffer.append(dto.getName());
			stringBuffer.append("-");
			stringBuffer.append(dto.getKor());
			stringBuffer.append("-");
			stringBuffer.append(dto.getEng());
			stringBuffer.append("-");
			stringBuffer.append(dto.getMath());
			stringBuffer.append("-");
			stringBuffer.append(dto.getTotal());
			stringBuffer.append("-");
			stringBuffer.append(dto.getAvg());
			fw.write(stringBuffer.toString() + "\r\n");
			fw.flush();
		}

	}//delete 끝
	
	
	
	
	
}
