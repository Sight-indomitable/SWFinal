package my.sw.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import my.sw.model.vo.BbsVO;

@Repository("bbsDAO")
public class BbsDAO extends EgovAbstractMapper	// tm
{
	public int insertBbs(BbsVO vo)
	{
		return insert("bbs.insertBbs",vo);
	}
	

	public int updateBbs(BbsVO vo)
	{
		return update("bbs.updateBbs",vo);
	}
	
	public int deleteBbs(BbsVO vo)
	{
		return delete("bbs.deleteBbs",vo);
	}
	
	public BbsVO selectBbs(BbsVO vo)
	{
		return selectOne("bbs.selectBbs",vo);
	}
	
	
	public List<BbsVO> selectBbsList(BbsVO vo)
	{
		return selectList("bbs.selectBbsList",vo);
	}
	
	
}
