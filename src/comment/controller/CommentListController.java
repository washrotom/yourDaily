package comment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import comment.service.CommentService;
import comment.service.CommentServiceImpl;

import model.Comment;


/**
 * Servlet implementation class CommentListController
 */
@WebServlet("/CommentListController")
public class CommentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

				// ��û�� ������ ���ڵ� ����
				request.setCharacterEncoding("euc-kr");
				response.setContentType("text/html; charset=EUC-KR");
				response.setCharacterEncoding("euc-kr");

				// ����� ������ ���� ��ü ����
				CommentService service = new CommentServiceImpl();
				
				Comment c = new Comment();

				// �� ��ü �˻� ��� ����
				ArrayList<Comment> list = (ArrayList<Comment>) service.CommentAll(c);

				// list�� request�� ����
				request.setAttribute("list", list);
				

				// �۸�� ����������� �̵�
				RequestDispatcher dispatcher = request.getRequestDispatcher("/board/search.jsp");
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
