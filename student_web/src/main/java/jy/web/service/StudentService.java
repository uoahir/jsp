package jy.web.service;

import static jy.web.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import jy.web.model.dao.StudentDao;
import jy.web.model.dto.Student;

public class StudentService {
	
	// 싱글톤패턴 구현
//	private StudentService sc;
//	private StudentService() {
//	}
//	public static StudentService getStudentService() {
//		if(sc==null) {
//			sc = new StudentService();
//		}
//	}
	
	private StudentDao dao = new StudentDao();
	
	public List<Student> searchAll(){
		Connection conn = getConnection();
		List<Student> students = dao.searchAll(conn);
		close(conn);
		return students;
	}
	
	public List<Student> searchByName(String name){
		Connection conn = getConnection();
		List<Student> students = dao.searchByName(conn,name);
		close(conn);
		return students;
	}
	
	public List<Student> searchByGrade(int grade){
		Connection conn = getConnection();
		List<Student> students = dao.searchByGrade(conn,grade);
		close(conn);
		return students;
	}
	
	public int insertStudent(Student s) {
		Connection conn = getConnection();
		int result = dao.insertStudent(conn, s);
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateStudent(Student s) {
		Connection conn = getConnection();
		int result = dao.updateStudent(conn,s);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
