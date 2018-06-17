package my.android.model.dao;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import my.android.model.vo.ClientVO;
import my.sw.model.vo.UserVO;

@Repository("cliDAO")
public class ClientDAO extends EgovAbstractMapper
{
	/**
	 * 안드로이드 유저 회원가입
	 * 
	 * @param 	vo 입력할 클라이언트 데이터
	 * @return	결과값, 재대로 들어가면 1, 아니면  0;
	 */
	public int insertClient(ClientVO vo)
	{
		return insert("client.insertClient",vo);
	}
		
	/**
	 * 안드로이드 유저 로그인
	 * @param vo
	 * @return
	 */
	public ClientVO selectClient(ClientVO vo)
	{
		return selectOne("client.selectClient",vo);
	}
	
}
