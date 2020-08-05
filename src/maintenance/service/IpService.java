package maintenance.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public interface IpService {
	public void IpTracker(HttpServletRequest request, String path, String trakerId)throws IOException;
}
