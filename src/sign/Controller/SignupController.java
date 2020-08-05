package sign.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.SignVO;
import maintenance.service.IpService;
import maintenance.service.IpServiceImpl;
import sign.Service.signService;
import sign.Service.signServiceImpl;

import maintenance.service.FileMakeService;
import maintenance.service.FileMakeServiceImpl;

/**
 * Servlet implementation class SignupController
 */

//member.contorller.JoinController.java
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
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
		String name = request.getParameter("name");
		int type = Integer.parseInt(request.getParameter("type")); 
		
		//아이디 중복 확인
		
		
		
		/*IP AND ID TRAKER*/
		//HttpSession session = request.getSession(false);
		String path = request.getSession().getServletContext().getRealPath("/");
		System.out.println(path);
		IpService ipp = new IpServiceImpl();
		String TrakerId = "SINGUP";
		ipp.IpTracker(request, path, TrakerId);
		/*IP AND ID TRAKER END*/
		
		//FileMakeService m = new FileMakeServiceImpl();
		//m.userFileM(id, path); // 개인페이지 만들려다가 실패함 ㅅㄱ
		
		SignVO vo = new SignVO(id, pwd, name, 1); // 기본값이 1이기 때문에 1를 넘겨줘야함.
		service.getSignVO(id);
		String idc = request.getParameter("id");
		System.out.println(idc);
		if(idc == id) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/sign_up/sign_up_overlab.jsp");
			if(dispatcher != null) {
				dispatcher.forward(request, response);
			}
			
		} else {
			service.join(vo);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/in/in.jsp");
			if(dispatcher != null) {
				dispatcher.forward(request, response);
			}
			
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
