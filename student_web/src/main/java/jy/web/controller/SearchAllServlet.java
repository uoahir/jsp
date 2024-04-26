package jy.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jy.web.model.dto.Student;
import jy.web.service.StudentService;

/**
 * Servlet implementation class SearchAllServlet
 */
@WebServlet("/student/searchall.do")
public class SearchAllServlet extends HttpServlet {
	
	private StudentService sc = new StudentService();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 학생을 전체 조 회 해아 함 ! 
		// service 에서 받아온 전체 학생 리스트를 받아와서 jsp 파일로 넘겨주기만 하면 됨  !
		List<Student> students = sc.searchAll();
		
		request.setAttribute("students", students);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/student/student.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
