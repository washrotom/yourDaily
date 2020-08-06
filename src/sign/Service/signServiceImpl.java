package sign.Service;

import VO.SignVO;
import sign.DAO.signDao;
import sign.DAO.signDaoImpl;

public class signServiceImpl implements signService{
	private signDao dao;
	
	public signServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new signDaoImpl();
		
	}

	@Override
	public void join(SignVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
		
	}

	@Override
	public SignVO getSignVO(String id) {
		// TODO Auto-generated method stub
		return dao.select(id);
	}

	@Override
	public void editSignVO(SignVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delSignVO(String id) {
		dao.delete(id);
		
	}

	@Override
	public boolean login(String id, String pwd) {
		SignVO vo = dao.select(id);
		if (vo == null || !vo.getPwd().equals(pwd)) {
			return false;
		} else {
			return true;
		}	}

	@Override
	public void rePwd(SignVO vo) {
		dao.updatePwd(vo);
	}
}
