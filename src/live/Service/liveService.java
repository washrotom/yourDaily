package live.Service;

import java.util.List;

import VO.LiveVO;

//board.service.Service.java
public interface liveService {
	void addLive(LiveVO l);
	LiveVO getLive(String id);
	List getAll(String id);
	void editLive(LiveVO l);
	void delLive(String id, String title);

}
