package live.Service;

import java.util.List;

import VO.LiveVO;
import live.DAO.liveDao;
import live.DAO.liveDaoImpl;

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
	public LiveVO getLive(String name) {
		return dao.select(name);
	}

	@Override
	public List getAll(String name) {
		return dao.selectAll(name);
	}

	@Override
	public void editLive(LiveVO l) {
		dao.update(l);
		
	}

	@Override
	public void delLive(String name, String title) {
		dao.delete(name, title);
	}

}
