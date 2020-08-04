package comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.service.CommentService;
import comment.service.CommentServiceImpl;
import model.Comment;
import model.Member;

/**
 * Servlet implementation class CommentInsertController
 */
@WebServlet("/CommentInsertController")
public class CommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertController() {
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
		CommentService service = new CommentServiceImpl();
		
		String comment_ID = request.getParameter("comment_ID");
		String comment_Content = request.getParameter("comment_Content");
		int comment_Bnum = Integer.parseInt(request.getParameter("comment_Bnum"));
		
		Comment c = new Comment();
		c.setComment_ID(comment_ID);
		c.setComment_Content(comment_Content);
		c.setComment_Bnum(comment_Bnum);  
		
		service.writeComment(c);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher
				("/board/search.jsp");
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
