package my.sw.model.vo;

public class UserVO 
{
	private String  user_id;	// 유저의 id, pk
	private String	pw; 		// 유저 비밀번호
	private String	phone;		// 유저 핸드폰 번호
	private String  gender;		// 유저 성별
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
