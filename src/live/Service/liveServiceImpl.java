package live.Service;

import java.util.List;

import VO.LiveVO;
import live.DAO.liveDao;
import live.DAO.liveDaoImpl;

//board.service.ServiceImpl.java
public class liveServiceImpl implements liveService{
	
	private liveDao dao;
	
	public liveServiceImpl() {
		dao = new liveDaoImpl();
	}

	@Override
	public void addLive(LiveVO l) {
		dao.insert(l);
		
	}

	@Override
	public LiveVO getLive(String id) {
		return dao.select(id);
	}

	@Override
	public List getAll(String id) {
		return dao.selectAll(id);
	}

	@Override
	public void editLive(LiveVO l) {
		dao.update(l);
		
	}

	@Override
	public void delLive(String id, String title) {
		dao.delete(id, title);
	}

}
