package comments.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.CommentVO;
import VO.LiveVO;
import comments.Service.CommentService;
import comments.Service.CommentServiceImpl;
import live.Service.liveService;
import live.Service.liveServiceImpl;


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

		// 疫꿸퀡�뮟占쎌뱽 占쎌젫�⑤벏釉� 占쎄퐣�뜮袁⑸뮞 揶쏆빘猿� 占쎄문占쎄쉐
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
		liveService service2 = new liveServiceImpl();
	

		//   泥�  罹�         �뼥 
		int num = Integer.parseInt(request.getParameter("num"));

		//     驪�   玉�          
		LiveVO livenum = service2.getLiveNumber(num);
		CommentVO c = new CommentVO();

          c.setComment_Bnum(num); //占쎈연疫꿸퀡彛� 占쎈땾占쎌젟
       
		ArrayList<CommentVO> commentlist = (ArrayList<CommentVO>) service.CommentAll(c);

		// list   request       
		request.setAttribute("commentlist", commentlist);

		// b   request       
		request.setAttribute("livenum", livenum);

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
