package sign.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.SignVO;
import live.Service.liveService;
import live.Service.liveServiceImpl;
import sign.Service.signService;
import sign.Service.signServiceImpl;

/**
 * Servlet implementation class SigninController
 */
@WebServlet("/SigninController")
public class SigninController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninController() {
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
		HttpSession session = request.getSession();
		boolean flag = false;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		SignVO vo = service.getSignVO(id);
		
		
		if(vo!=null&&pwd.equals(vo.getPwd())) {
			session.setAttribute("id", id);
			flag = true;
		}
		session.setAttribute("flag", flag);
		
/*		String path = "";
		if(m.getType() == 1) {
			path = "/view/order/list.jsp";
		} else path = "/view/seller/list.jsp";
*/		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/in/loginComplete.jsp");
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
