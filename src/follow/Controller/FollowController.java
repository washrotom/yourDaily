package follow.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.print.attribute.standard.Severity;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

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
 * Servlet implementation class FollowController
 */
@WebServlet("/FollowController")
public class FollowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		followService service = new followServiceImpl();
		liveService lservice = new liveServiceImpl();
		signService sservice = new signServiceImpl();
		
		HttpSession session = request.getSession(false);
		String id = request.getParameter("id");
		ArrayList<LiveVO> list = (ArrayList<LiveVO>) lservice.getAll(id);
		
		
		String myid = request.getParameter("myid");
		FollowVO vo = new FollowVO(0,id,1,0,myid);
		service.addFollow(vo);
		String liveid = (String) session.getAttribute("liveid");
		String signid = (String) session.getAttribute("id");
		
		ArrayList<FollowVO> followinglist = (ArrayList<FollowVO>) service.listFollowing(id);
		String set = vo.getId() + vo.getMyid();
		HashSet<FollowVO> setlist = new HashSet<FollowVO>(set);
		System.out.println(set);
		
		
		if(followinglist != null) {
			request.setAttribute("followinglist", followinglist);
			request.setAttribute("listsize", followinglist.size());
		} else {
			request.setAttribute("followinglist", "팔로우리스트가 없습니다.");
			request.setAttribute("listsize", "0");
		}
		
		request.setAttribute("list", list);
		request.setAttribute("size", list.size());
		
		System.out.println(vo.getId() + vo.getMyid());
		
		
		String path = "/confirm/followingResultList.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
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
