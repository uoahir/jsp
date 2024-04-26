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
 * Servlet implementation class SearchByNameServlet
 */
@WebServlet("/student/searchbyname.do")
public class SearchByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentService service = new StudentService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인풋으로 받은 ㅇ이름을 받아와서 ~ 서비스로직에 전달~ 다오에서로직 돌려서 리턴된 값 다시 받아오기 ~ 
		// 이름은 ~ 중복가능이니까 ~ 리스트로 받아와야 함 ~ 
		String name = request.getParameter("name");
		List<Student> students = service.searchByName(name);
		
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
