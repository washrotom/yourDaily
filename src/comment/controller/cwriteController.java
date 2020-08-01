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

		// ����� ������ ���� ��ü ����
		commentService service = new CommentServiceImpl();

		// ��û �Ķ���� �� �б�
		String Name = request.getParameter("Name");
		String Password = request.getParameter("Password");
		String Content = request.getParameter("Content");
		
		

		// ��û �Ķ���ͷ� ���� ������ Board ��ü ����
		Comment c = new Comment();
		c.setName(Name);
		c.setPassword(Password);
		c.setContent(Content);

		// ������ ���ۼ� ��� ����
		service.writeComment(c);

		// �۸������ �̵�
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
