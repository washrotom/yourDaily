package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.Service;
import board.service.ServiceImpl;
import model.Board;

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

		// ��û�� ������ ���ڵ� ����
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");

		// ����� ������ ���� ��ü ����
		Service service = new ServiceImpl();

		// ��û �Ķ���� �� �б�
		int num = Integer.parseInt(request.getParameter("num"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// ��û �Ķ���ͷ� ���� ������ Board ��ü ����
		Board b = new Board(num, writer, null, title, content);

		// ������ �ۼ��� ��� ����
		service.editBoard(b);

		// �۸������ �̵�
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
