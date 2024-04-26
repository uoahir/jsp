package jy.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jy.web.model.dto.Student;
import jy.web.service.StudentService;

/**
 * Servlet implementation class InsertStudentServlet
 */
@WebServlet("/student/insertstudent.do")
public class InsertStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = new StudentService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 회원등록 제출 버튼 클릭시
		// 각각의 input 태그에 담긴 value 값을 여기에서 저장해서 ! service 로직으로 넘겨줘야 한당 !!!
		Student s = Student.builder().studentName(request.getParameter("name")).age(Integer.parseInt(request.getParameter("age"))).gender(request.getParameter("gender")).grade(Integer.parseInt(request.getParameter("grade"))).classNumber(Integer.parseInt(request.getParameter("class"))).height(Double.parseDouble(request.getParameter("height"))).address(request.getParameter("address")).phone(request.getParameter("phone")).build();
		
		System.out.println(s);
		int result = service.insertStudent(s);
		response.sendRedirect(request.getContextPath()+"/student/searchall.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
