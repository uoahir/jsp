<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>회원등록</legend>
		<form action="<%= request.getContextPath()%>/student/insertstudent.do" method="post">
			<label>이름 : <input type = "text" name="name"></label>
			<label>나이 : <input type= "number" name="age" min="8" max="13"></label>
			<div class="check">
				성별 : 
				<label class="check">남<input type= "radio" name = "gender" value="남"></label>
				<label class ="check">여<input type= "radio" name ="gender" value="여"></label>
			</div>
			<div class="check">
				학년 : 
				<label>1<input type = "radio" name="grade" value="1"></label>
				<label>2<input type = "radio" name="grade" value="2"></label>
				<label>3<input type = "radio" name="grade" value="3"></label>
				<label>4<input type = "radio" name="grade" value="4"></label>
				<label>5<input type = "radio" name="grade" value="5"></label>
				<label>6<input type = "radio" name="grade" value="6"></label>
			</div>
			<div class="check">
				반 : 
				<label>1<input type=radio name="class" value="1"></label>
				<label>2<input type=radio name="class" value="2"></label>
				<label>3<input type=radio name="class" value="3"></label>
				<label>4<input type=radio name="class" value="4"></label>
			</div>
			<label>키 : <input type="text" name="height"></label>
			<label>주소 : <input type="text" name="address"></label>
			<label>핸드폰 : <input type="text" name="phone"></label>
			<input type="submit" value="제출">
		</form>
		
	</fieldset>
	
	<style>
		form>label{
			display:block;
		}
		form div.check>label{
			display: inline;
		}
	</style>
</body>
</html>