package jy.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jy.web.model.dto.Student;
import static jy.web.common.JDBCTemplate.*;

public class StudentDao {
	
	public List<Student> searchAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Student> students = new ArrayList<>();
		String sql = "SELECT * FROM STUDENT";
		
		try {
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Student s = makeStudent(conn,rs);
				students.add(s);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return students;
	}
	
	public List<Student> searchByName(Connection conn, String name){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Student> students = new ArrayList<>();
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_NAME=?";
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Student s = makeStudent(conn,rs);
				students.add(s);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return students;
	}
	
	public List<Student> searchByGrade(Connection conn, int grade){
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<Student> students = new ArrayList<>();
		String sql = "SELECT * FROM STUDENT WHERE GRADE=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, grade);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student s = makeStudent(conn,rs);
				students.add(s);	
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return students;
	}
	
	public int insertStudent(Connection conn, Student s) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT VALUES (NO.NEXTVAL,?,?,?,?,?,?,?,?)";
		// 학생번호, 이름, 나이, 학년, 반, 성별, 키, 주소, 핸드폰
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getStudentName());
			pstmt.setInt(2, s.getAge());
			pstmt.setInt(3, s.getGrade());
			pstmt.setInt(4, s.getClassNumber());
			pstmt.setString(5, s.getGender());
			pstmt.setDouble(6, s.getHeight());
			pstmt.setString(7, s.getAddress());
			pstmt.setString(8, s.getPhone());
			
			result = pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateStudent(Connection conn, Student s) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET STUDENT_NAME=?, AGE=?, GRADE=?, CLASS_NUMBER=?, GENDER=?, HEIGHT=?,ADDRESS=?,PHONE=? WHERE STUDENT_NO = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,s.getStudentName());
			pstmt.setInt(2, s.getAge());
			pstmt.setInt(3, s.getGrade());
			pstmt.setInt(4, s.getClassNumber());
			pstmt.setString(5, s.getGender());
			pstmt.setDouble(6, s.getHeight());
			pstmt.setString(7, s.getAddress());
			pstmt.setString(8, s.getPhone());
			pstmt.setInt(9, s.getStudentNo());
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	
	}
	
	public Student makeStudent(Connection conn, ResultSet rs) throws SQLException{
		Student s = Student.builder()
				.studentNo(rs.getInt("student_no"))
				.studentName(rs.getString("student_name"))
				.age(rs.getInt("age"))
				.grade(rs.getInt("grade"))
				.classNumber(rs.getInt("class_number"))
				.height(rs.getDouble("height"))
				.address(rs.getString("address"))
				.phone(rs.getString("phone"))
				.gender(rs.getString("gender")).build();
		return s;
	}
}
