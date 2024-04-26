package jy.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jy.web.model.dto.Student;
import jy.web.service.StudentService;

/**
 * Servlet implementation class UpdateStudentEndServlet
 */
@WebServlet("/student/updatestudentend.do")
public class UpdateStudentEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private StudentService service = new StudentService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Student s = Student.builder().studentNo(Integer.parseInt(request.getParameter("number"))).studentName(request.getParameter("name"))
				.age(Integer.parseInt(request.getParameter("age")))
				.gender(request.getParameter("gender"))
				.grade(Integer.parseInt(request.getParameter("grade")))
				.classNumber(Integer.parseInt(request.getParameter("class")))
				.height(Double.parseDouble(request.getParameter("height")))
				.address(request.getParameter("address"))
				.phone(request.getParameter("phone")).build();
		
		int result = service.updateStudent(s);
		
		response.sendRedirect("/student/searchall.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
