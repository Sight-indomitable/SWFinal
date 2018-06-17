package my.android.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.android.model.dao.ClientDAO;
import my.android.model.vo.ClientVO;
import my.sw.service.CrudService;

@Service("cliService")
public class ClientServiceImpl implements CrudService<ClientVO> 
{
	@Autowired
	ClientDAO dao;
	
	@Override
	public void insert(ClientVO vo) {
		dao.insertClient(vo);
	}

	@Override
	public void update(ClientVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ClientVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClientVO select(ClientVO vo) {
		
		return dao.selectClient(vo);
	}

	@Override
	public List<ClientVO> selectList(ClientVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
