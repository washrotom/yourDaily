package follow.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.FollowVO;
import follow.Service.followService;
import follow.Service.followServiceImpl;

/**
 * Servlet implementation class FollowListController
 */
@WebServlet("/FollowListController")
public class FollowListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		followService service = new followServiceImpl();
		String myid = request.getParameter("myid");
		ArrayList<FollowVO> followinglist = (ArrayList<FollowVO>) service.listFollowing(myid);
		
		if(followinglist != null) {
			
			request.setAttribute("followinglist", followinglist);
			request.setAttribute("listsize", followinglist.size());
		} else {
			request.setAttribute("followinglist", "팔로우리스트가 없습니다.");
			request.setAttribute("listsize", "0");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
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
