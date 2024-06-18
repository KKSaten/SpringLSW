package com.lsw.app.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Repository;

import com.lsw.app.student.StudentDTO;

@Repository
public class StudentDAO {
	
	public List<StudentDTO> getStudents() throws Exception{
		
		File file = new File("C:\\study", "student.txt");
		FileReader fr;
		ArrayList<StudentDTO> ar = new ArrayList<StudentDTO>();
		
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				String s = br.readLine();
				
				if (s == null) {
					break;
				}
				if (s.isEmpty()) {
					
				}
				
				s = s.replace(",", "-");
				StringTokenizer st = new StringTokenizer(s, "-");
				while(st.hasMoreTokens()) {
					StudentDTO studentDTO = new StudentDTO();
					studentDTO.setNum(Long.parseLong(st.nextToken().trim()));
					studentDTO.setName(st.nextToken().trim());
					studentDTO.setKor(Integer.parseInt(st.nextToken().trim()));
					studentDTO.setEng(Integer.parseInt(st.nextToken().trim()));
					studentDTO.setMath(Integer.parseInt(st.nextToken().trim()));
					studentDTO.setTotal(Integer.parseInt(st.nextToken().trim()));
					studentDTO.setAvg(Double.parseDouble(st.nextToken().trim()));
					ar.add(studentDTO);
				}//while문 끝
				
			}//while문 끝
			
			br.close();
			fr.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
			
	} //getStudents() 끝


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
	
	
	//add
	public void add(StudentDTO studentDTO) throws Exception{
		
		List<StudentDTO> ar = this.getStudents();
		
		//도시명-기온-상태-습도		
		StringBuffer sb = new StringBuffer();
		Calendar ca = Calendar.getInstance();
		sb.append(ca.getTimeInMillis());
		sb.append("-");
		sb.append(studentDTO.getName());
		sb.append("-");
		sb.append(studentDTO.getKor());
		sb.append("-");
		sb.append(studentDTO.getEng());
		sb.append("-");
		sb.append(studentDTO.getMath());
		sb.append("-");
		sb.append(studentDTO.getTotal());
		sb.append("-");
		sb.append(studentDTO.getAvg());
		
		File file = new File("C:\\study", "student.txt");
		FileWriter fw = new FileWriter(file, true);
		fw.write(sb+"\r\n");
		fw.flush();
		
		fw.close();
	}
	
	
	
	//delete
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
