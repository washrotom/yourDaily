package comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import comment.service.CommentServiceImpl;

import model.Comment;
import comment.service.commentService;
/**
 * Servlet implementation class WriteController
 */
@WebServlet(name = "cwriteController", urlPatterns = { "/cwriteController" })
public class cwriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cwriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");

		// 기능을 제공할 서비스 객체 생성
		commentService service = new CommentServiceImpl();

		// 요청 파라메터 값 읽기
		String Name = request.getParameter("Name");
		String Password = request.getParameter("Password");
		String Content = request.getParameter("Content");
		
		

		// 요청 파라메터로 읽은 값으로 Board 객체 생성
		Comment c = new Comment();
		c.setName(Name);
		c.setPassword(Password);
		c.setContent(Content);

		// 서비스의 글작성 기능 실행
		service.writeComment(c);

		// 글목록으로 이동
        RequestDispatcher dispatcher = request.getRequestDispatcher
        ("/member/result.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
