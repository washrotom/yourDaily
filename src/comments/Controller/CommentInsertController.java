package comments.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.CommentVO;
import comments.Service.CommentService;
import comments.Service.CommentServiceImpl;


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

		// 湲곕뒫�쓣 �젣怨듯븷 �꽌鍮꾩뒪 媛앹껜 �깮�꽦
		CommentService service = new CommentServiceImpl();
		
		String comment_ID = request.getParameter("comment_ID");
		String comment_Content = request.getParameter("comment_Content");
		int comment_Bnum = Integer.parseInt(request.getParameter("comment_Bnum"));
		
		CommentVO c = new CommentVO();
		c.setComment_ID(comment_ID);
		c.setComment_Content(comment_Content);
		c.setComment_Bnum(comment_Bnum);  
		
		service.writeComment(c);
		
		request.setAttribute("c", c);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher
				("/comments/search.jsp");
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
