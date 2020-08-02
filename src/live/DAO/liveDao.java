package live.DAO;

import java.util.List;

import VO.LiveVO;

////board.dao.DaoImpl.Dao
public interface liveDao {
	public void insert(LiveVO l);
	public LiveVO select(String id);
	List selectAll(String id);
	public void update(LiveVO l);
	public void delete(String id, String title);

}
