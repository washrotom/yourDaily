package live.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		
		//�̹��� ���� (���, �̸� ���)
		/*
		String uploadPath = request.getSession().getServletContext().getRealPath("/");
		uploadPath = uploadPath + "img";
		System.out.println(uploadPath);
		
		String img = "dummy"; // �̹��� �̸�
		int maxSize = 1024 * 1024 * 10; // �̹��� �ִ� ũ��
		MultipartRequest mult = null; // 
		*/

		ServletContext uploadpath = getServletContext(); //���ø����̼ǿ� ���� ������ ServletContext ��ü�� ���� ��. 
		String saveDir = uploadpath.getRealPath("img"); 
		System.out.println("������ >> " + saveDir);
		
		int maxsize = 3*1024*1024; // 3MB
		
		String encoding = "euc-kr";
		
		MultipartRequest mult = new MultipartRequest(request, saveDir, maxsize, encoding, new DefaultFileRenamePolicy());
		//
		
		boolean flag = false;
		
		//request -> mult
		String id = mult.getParameter("id");
		String title = mult.getParameter("title");
		String content = mult.getParameter("content");
		String path = mult.getParameter("file");
		
		LiveVO l = new LiveVO(0, id, null, title, content, path, 0);
		
		//�̹��� ����
		try {
			Enumeration files = mult.getFileNames();
			
			while(files.hasMoreElements()) {
				String file1 = (String) files.nextElement();
				String img = mult.getOriginalFileName(file1);
				saveDir = saveDir + "\\" + img;
				File file = mult.getFile(file1);
				System.out.println(img);
				l.setPath(img);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		//
		
		service.addLive(l);
		
		if(l != null) {
			session.setAttribute("id", id);
			flag = true;
		}
		
		session.setAttribute("flag", flag);
		
		/*IP AND ID TRAKER*/
		path = request.getSession().getServletContext().getRealPath("/");
		System.out.println(path);
		IpService ipp = new IpServiceImpl();
		String TrakerId = (String) session.getAttribute("id");
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
