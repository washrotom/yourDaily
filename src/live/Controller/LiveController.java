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
import maintenance.service.IpService;
import maintenance.service.IpServiceImpl;

//board.controlloer.WriteController.java
/**
 * Servlet implementation class LiveController
 */
@WebServlet("/LiveController")
public class LiveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LiveController() {
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
		
		live.Service.liveService service = new live.Service.liveServiceImpl();
		HttpSession session = request.getSession();
		boolean flag = false;
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		LiveVO l = new LiveVO(0, id, null, title, content, null);
		service.addLive(l);
		
		if(l != null) {
			session.setAttribute("id", id);
			flag = true;
		}
		session.setAttribute("flag", flag);
		
		/*IP AND ID TRAKER*/
		//HttpSession session = request.getSession(false);
		String path = request.getSession().getServletContext().getRealPath("/");
		System.out.println(path);
		IpService ipp = new IpServiceImpl();
		String TrakerId = "SINGUP";
		ipp.IpTracker(request, path, TrakerId);
		/*IP AND ID TRAKER END*/
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/live/result.jsp");
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
