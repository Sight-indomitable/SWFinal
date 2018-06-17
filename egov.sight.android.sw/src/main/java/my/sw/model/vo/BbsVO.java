package my.sw.model.vo;


public class BbsVO
{
	private int 	bbs_id;				// 게시판 글 번호, pk 
	private String  title;				// 제목
	private String  content;			// 내용 
	private String  user_id;			// 글쓴이
	
	// ------------------------- getters ---------------------------
	public int getBbs_id() {
		return bbs_id;
	}
	public void setBbs_id(int bbs_id) {
		this.bbs_id = bbs_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public void dbConvertToText()
	{
		content.replace(System.getProperty("line.separator"),"</br>");
		content.replace("  ","&nbsp;");
		content.replace("<script>","script");        // xss 예방

		title.replace(" ","&nbsp");
		title.replace("<script>","script");  // xss 예방
	}
	
	public void textConvertToDb()
	{
		content.replace("</br>",System.getProperty("line.separator"));
		content.replace("&nbsp;","  ");
		content.replace("script","<script>");        // xss 예방

		title.replace("&nbsp"," ");
		title.replace("script","<script>");  // xss 예방
	}
	
}
