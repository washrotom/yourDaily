package live.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.CommentVO;
import VO.LiveVO;
import comments.Service.CommentService;
import comments.Service.CommentServiceImpl;
import live.Service.liveService;
import live.Service.liveServiceImpl;


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

		//   청             湄      
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");

		//                     체     
		
		liveService service = new liveServiceImpl();
		CommentService service2 = new CommentServiceImpl();

		//   청  캘         閨 
		int num = Integer.parseInt(request.getParameter("num"));

		//     毬   講          
		LiveVO livenum = service.getLiveNumber(num);
		CommentVO c = new CommentVO();

          c.setComment_Bnum(num); //�뿬湲곕쭔 �닔�젙
       
		ArrayList<CommentVO> commentlist = (ArrayList<CommentVO>) service2.CommentAll(c);

		// list   request       
		request.setAttribute("commentlist", commentlist);

		// b   request       
		request.setAttribute("livenum", livenum);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/comments/search.jsp");
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