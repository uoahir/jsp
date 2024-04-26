<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 지언이의 학생 프로그램 ! </h3>
	<button onclick = "searchAll();">전체조회</button>
	
	<script>
		function searchAll(){
			location.assign("<%=request.getContextPath() %>/student/searchall.do");
		}
	</script>

</body>
</html>