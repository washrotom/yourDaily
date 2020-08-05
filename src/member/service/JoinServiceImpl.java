package member.service;

import member.dao.JoinDao;
import member.dao.JoinDaoImpl;
import model.Member;

public class JoinServiceImpl implements JoinService {

	private JoinDao dao;

	public JoinServiceImpl() {
		dao = new JoinDaoImpl();
	}

	@Override
	public void join(Member m) {
		// TODO Auto-generated method stub
		dao.insert(m);
	}

	@Override
	public Member getMember(String id) {
		// TODO Auto-generated method stub
		return dao.select(id);
	}

	@Override
	public void editMember(Member m) {
		// TODO Auto-generated method stub
		dao.update(m);
	}

	@Override
	public void delMember(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

}
