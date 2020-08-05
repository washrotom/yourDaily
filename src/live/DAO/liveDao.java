package live.DAO;

import java.util.List;

import VO.LiveVO;

public interface liveDao {
	public void insert(LiveVO l);
	public LiveVO select(String id);
	List selectAll(String id);
	public void update(LiveVO l);
	public void delete(int num);
	LiveVO selectNum(int num);

}
