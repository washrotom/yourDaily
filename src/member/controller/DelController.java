package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import member.service.JoinService;
import member.service.JoinServiceImpl;
import model.Member;

/**
 * Servlet implementation class DelController
 */
@WebServlet("/DelController")
public class DelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelController() {
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
		// 요청과 응답의 인코딩 설정
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");
		


		// 서비스 객체 생성
		JoinService service = new JoinServiceImpl();

		// 세션 생성
		HttpSession session = request.getSession(false);

		// 세션에서 로그인 한 id 읽는다.
		String id = (String) session.getAttribute("id");
		
	

		// 세션 무효화
		session.invalidate();

		// 서비스에서 멤버 삭제 메서드 호출
		service.delMember(id);

		// 메뉴 페이지로 이동
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
