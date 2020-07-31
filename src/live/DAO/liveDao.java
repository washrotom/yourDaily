package live.DAO;

import java.util.List;

import VO.LiveVO;

public interface liveDao {
	public void insert(LiveVO l);
	public LiveVO select(String name);
	List selectAll(String name);
	public void update(LiveVO l);
	public void delete(String name, String title);

}
