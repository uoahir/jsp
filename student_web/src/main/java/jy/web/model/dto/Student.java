package jy.web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

	private int studentNo;
	private String studentName;
	private int age;
	private int grade;
	private int classNumber;
	private String gender;
	private double height;
	private String address;
	private String phone;
}
//DB데이터 student계정을 이용하기
//student_no number pk sequence부여
//student_name varchar2(50) not null 
//age number
//grade number
//classnumber number
//height number
//address varchar2(100)
//phone varchar2(100)
//gender varchar2(5)