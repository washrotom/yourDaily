package live.Service;

import java.util.List;

import VO.LiveVO;

public interface liveService {
	void addLive(LiveVO l);
	LiveVO getLive(String id);
	List getAll(String id);
	void editLive(LiveVO l);
	void delLive(int num);
	LiveVO getLiveNumber(int num);

}
