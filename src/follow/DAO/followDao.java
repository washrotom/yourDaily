package follow.DAO;

import java.util.List;

public interface followDao {
	public void add(String id);
	public void accept(String id);
	List select(String id);
	public void delete(String id);
}
