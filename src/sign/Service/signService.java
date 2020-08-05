package sign.Service;

import VO.SignVO;

public interface signService {
	void join(SignVO vo);
	SignVO getSignVO(String id);
	void editSignVO(SignVO vo);
	void delSignVO(String id);
	boolean login(String id, String pwd);
	void rePwd(SignVO vo);
}
