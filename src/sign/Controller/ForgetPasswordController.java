package sign.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.SignVO;
import sign.Service.signService;
import sign.Service.signServiceImpl;

/**
 * Servlet implementation class ForgetPasswordController
 */
@WebServlet("/ForgetPasswordController")
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		signService service = new signServiceImpl();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		SignVO vo = new SignVO(id, pwd, null, 0);
		
		service.rePwd(vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/in/in.jsp");
		if(dispatcher != null) {
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
