package maintenance.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import maintenance.service.IpService;


// �������� request.getRemoteAddr(); ���� �޴´�.
//
//
public class IpServiceImpl implements IpService {
	@Override
	public void IpTracker(HttpServletRequest request, String path, String id) throws IOException {
	
		String ip = request.getHeader("X-Forwarded-For");
		
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		     ip = request.getHeader("Proxy-Client-IP"); 
		 } 
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		     ip = request.getHeader("WL-Proxy-Client-IP"); 
		 } 
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		     ip = request.getHeader("HTTP_CLIENT_IP"); 
		 } 
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		     ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
		 } 
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		     ip = request.getRemoteAddr(); 

		System.out.println(ip);
		 // ���� �ڽ��� ���� ���
		path = path + "log";
		//System.out.println(path);
		FileMakeService mK = new FileMakeServiceImpl();
		mK.FileM("log.txt", path, ip, id);
	
		
	}

	}
}
