package my.sw.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.sw.model.dao.UserDAO;
import my.sw.model.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements CrudService<UserVO>
{
	@Autowired
	UserDAO dao;
	
	@Override
	public void insert(UserVO vo) {
		dao.insertUser(vo);
	}

	@Override
	public void update(UserVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO select(UserVO vo) {
		return dao.selectUser(vo);
	}

	@Override
	public List<UserVO> selectList(UserVO vo) {
		return dao.selectUserList(vo);
	}

}
