package live.Service;

import java.util.List;

import VO.LiveVO;

public interface liveService {
	void addLive(LiveVO l);
	LiveVO getLive(String name);
	List getAll(String name);
	void editLive(LiveVO l);
	void delLive(String name, String title);

}
