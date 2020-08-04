package live.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.FollowVO;
import VO.LiveVO;
import VO.SignVO;
import follow.Service.followService;
import follow.Service.followServiceImpl;
import live.Service.liveService;
import live.Service.liveServiceImpl;
import sign.Service.signService;
import sign.Service.signServiceImpl;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/ListController")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");

		followService servicefollow = new followServiceImpl();
		liveService service = new liveServiceImpl();
		signService sservice = new signServiceImpl();
		HttpSession session = request.getSession(false);
		
		String id = request.getParameter("id");
		ArrayList<LiveVO> list = (ArrayList<LiveVO>) service.getAll(id);
		
		String myid = request.getParameter("myid");
		String signid = (String) session.getAttribute("id");
		
		// FollowVo���� �ȷο� �� ����� �����ϴ� �� --------------------------------------
		FollowVO vo = servicefollow.followListSelect(id, signid);
		String path = "";
		if(vo==null) {
			path = "/confirm/list.jsp";
		} else {
			path = "/confirm/followingResultList.jsp";
		}
		// -----------------------------------------------------------------------
		
		request.setAttribute("list", list);
		request.setAttribute("size", list.size());

		
		//----------------------- �ȷο� ����Ʈ �����ִ� �� --------------------------------------------------------
		ArrayList<FollowVO> followinglist = (ArrayList<FollowVO>) servicefollow.listFollowing(id);
		
		if(followinglist != null) {
			request.setAttribute("followinglist", followinglist);
			request.setAttribute("listsize", followinglist.size());
		} else {
			request.setAttribute("followinglist", "�ȷο�����Ʈ�� �����ϴ�.");
			request.setAttribute("listsize", "0");
		}
		// -------------------------------------------------------------------------------------------------
		
		
		
		//------------------------ �ȷ��� ����Ʈ �����ִ� �� ------------------------------------------------------
		ArrayList<FollowVO> followerlist = (ArrayList<FollowVO>) servicefollow.listFollower(id);
		
		if(followerlist != null) {
			request.setAttribute("followerlist", followerlist);
			request.setAttribute("followerlistsize", followerlist.size());
		} else {
			request.setAttribute("followerlist", "�ȷ��׸���Ʈ�� �����ϴ�.");
			request.setAttribute("followerlistsize", "0");
		}
		// ------------------------------------------------------------------------------------------------
		// ----------------------- ���� �ȷο� Ȥ�� �˻��� ����� �ȷο��� ����Ʈ ------------------------------------------------------
		ArrayList<FollowVO> myfollowinglist = (ArrayList<FollowVO>) servicefollow.mylistFollowing(id);
				
		if(followinglist != null) {
			request.setAttribute("myfollowinglist", myfollowinglist);
			request.setAttribute("mylistsize", myfollowinglist.size());
		} else {
			request.setAttribute("myfollowinglist", "�ȷο츮��Ʈ�� �����ϴ�.");
			request.setAttribute("mylistsize", "0");
		}
		// -----------------------------------------------------------------------------------------
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
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
