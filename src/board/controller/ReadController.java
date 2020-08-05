package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.Service;
import board.service.ServiceImpl;
import comment.service.CommentService;
import comment.service.CommentServiceImpl;
import model.Board;
import model.Comment;

/**
* Servlet implementation class SearchController
*/
@WebServlet(name = "ReadController", urlPatterns = { "/ReadController" })
public class ReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//   û             ڵ      
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");

		//                     ü     
		Service service = new ServiceImpl();
		CommentService service2 = new CommentServiceImpl();

		//   û  Ķ         б 
		int num = Integer.parseInt(request.getParameter("num"));

		//     ϳ   ˻          
		Board b = service.getBoard(num);
		Comment c = new Comment();

          c.setComment_Bnum(num); //여기만 수정

		//      ü  ˻          
		ArrayList<Comment> list = (ArrayList<Comment>) service2.CommentAll(c);

		// list   request       
		request.setAttribute("list", list);

		// b   request       
		request.setAttribute("b", b);
		request.setAttribute("c", c);
		
		
		
		
		

		//                     ̵ 
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/board/search.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}