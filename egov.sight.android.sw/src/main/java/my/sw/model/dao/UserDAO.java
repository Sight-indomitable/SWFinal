package my.sw.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import my.sw.model.vo.UserVO;

@Repository("userDAO")
public class UserDAO extends EgovAbstractMapper
{
	
	public int insertUser(UserVO vo){
		return insert("user.insertUser",vo);
	}
	
	public int updateUser(UserVO vo){
		return update("user.updateUser",vo);
	}
	public int deleteUser(UserVO vo){
		return delete("user.deleteUser",vo);
	}
	
	public UserVO selectUser(UserVO vo){
		return selectOne("user.selectUser",vo);
	}
	
	public List<UserVO> selectUserList(UserVO vo){
		return selectList("user.selectUserList",vo);
	}
	
}
