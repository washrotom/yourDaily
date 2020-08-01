package follow.Service;

import java.util.List;

public interface followService {
	void addFollow(String id);
	void acceptFollow(String id);
	List listFollow(String id);
	void unFollow(String id);
}
