package sign.DAO;

import VO.SignVO;

public interface signDao {
	void insert(SignVO vo);
	SignVO select(String id);
	void update(SignVO vo);
	void delete(String id);
	void updatePwd(SignVO vo);
}
