package comments.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comments.Service.CommentService;
import comments.Service.CommentServiceImpl;


/**
 * Servlet implementation class CommentDelController
 */
@WebServlet("/CommentDelController")
public class CommentDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDelController() {
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

		// �슂泥� �뙆�씪硫뷀꽣 媛� �씫湲�
		int comment_Num = Integer.parseInt(request.getParameter("comment_Num"));

		// �꽌鍮꾩뒪�쓽 湲��궘�젣 湲곕뒫 �떎�뻾
		service.DelComment(comment_Num);
		

		
		// 湲�紐⑸줉�쑝濡� �씠�룞
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/result.jsp");
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
