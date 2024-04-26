<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List, jy.web.model.dto.Student" %>
<% List<Student> students = (List<Student>)request.getAttribute("students"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>학생 조회</h3>
	<form action="<%= request.getContextPath() %>/student/searchbyname.do">
		<label>학생이름 : <input type = "text" name = "name"></label>
		<input type= "submit" value="검색">
	</form>
	<form action="<%= request.getContextPath() %>/student/searchbygrade.do">
		<label>학년 : <input type = "number" name = "grade" min="1" max="6"></label>
		<input type= "submit" value="검색">
	</form>
	<form action="<%= request.getContextPath()%>/student/addstudent.do">
		<input type="submit" value="등록">
	</form>
	<form action ="<%= request.getContextPath()%>/student/updatestudent.do">
		<input type="submit" value="수정">
	</form>
	<table>
		<tr>
			<th>학생번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>성별</th>
			<th>학년</th>
			<th>반</th>
			<th>키</th>
			<th>주소</th>
			<th>핸드폰</th>
		</tr>
		<tbody>
		<%if(students!=null){
			for(Student s : students){%>
			<tr>
				<td><%=s.getStudentNo() %></td>
				<td><%=s.getStudentName() %></td>
				<td><%=s.getAge() %></td>
				<td><%=s.getGender() %></td>
				<td><%=s.getGrade() %></td>
				<td><%=s.getClassNumber() %></td>
				<td><%=s.getHeight() %></td>
				<td><%=s.getAddress() %></td>
				<td><%=s.getPhone() %></td>
			</tr>
		<%} 
		}%>
		</tbody>
	</table>
	
	
</body>
</html>