package my.sw.service;

import java.util.List;


public interface CrudService<VO>
{
	public void insert(VO vo);
	
	public void update(VO vo);
	
	public void delete(VO vo);
	
	public VO select(VO vo);
	
	public List<VO> selectList(VO vo);
}
