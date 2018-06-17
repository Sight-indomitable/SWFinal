package my.sw.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.sw.model.dao.BbsDAO;
import my.sw.model.vo.BbsVO;

@Service("bbsService")
public class BbsServiceImpl implements CrudService<BbsVO>
{
	@Autowired
	BbsDAO dao;
	
	@Override
	public void insert(BbsVO vo) {
		dao.insertBbs(vo);
	}

	@Override
	public void update(BbsVO vo) {
		dao.updateBbs(vo);
	}

	@Override
	public void delete(BbsVO vo) {
		dao.deleteBbs(vo);
	}

	@Override
	public BbsVO select(BbsVO vo) {
		return dao.selectBbs(vo);
	}

	@Override
	public List<BbsVO> selectList(BbsVO vo) {
		return dao.selectBbsList(vo);
	}

}
