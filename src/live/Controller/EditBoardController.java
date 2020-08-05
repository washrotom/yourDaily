package live.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.LiveVO;
import live.Service.liveService;
import live.Service.liveServiceImpl;


/**
 * Servlet implementation class EditBoardController
 */
@WebServlet("/EditBoardController")
public class EditBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditBoardController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// �슂泥�怨� �쓳�떟�쓽 �씤肄붾뵫 �꽕�젙
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");

		// 湲곕뒫�쓣 �젣怨듯븷 �꽌鍮꾩뒪 媛앹껜 �깮�꽦
		liveService service = new liveServiceImpl();

		// �슂泥� �뙆�씪硫뷀꽣 媛� �씫湲�
		int num = Integer.parseInt(request.getParameter("num"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String path = request.getParameter("path");

		// �슂泥� �뙆�씪硫뷀꽣濡� �씫�� 媛믪쑝濡� Board 媛앹껜 �깮�꽦
		LiveVO l = new LiveVO(num, writer, null, title, content, path, 1);

		// �꽌鍮꾩뒪�쓽 湲��닔�젙 湲곕뒫 �떎�뻾
		service.editLive(l);
		

		// 湲�紐⑸줉�쑝濡� �씠�룞
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/result.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}