package my.sw.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import my.sw.model.vo.BbsVO;
import my.sw.model.vo.UserVO;
import my.sw.service.CrudService;

@Controller
public class BbsController
{
	Logger logger = LogManager.getLogger(BbsController.class.getName());

	@Autowired
	CrudService<BbsVO> service;
	
	/**
	 * 맨 처음 게시판에 들어갓을때 보게 될 게시글 리스트
	 * @param vo
	 * @param mo
	 * @return	게시판 리스트를 보여줄 jsp 파일
	 */
	@RequestMapping(value="bbsListView.do", method = RequestMethod.GET)
	public String bbsListView(BbsVO vo , Model mo)
	{
		List<BbsVO> resultSet = service.selectList(vo);
		mo.addAttribute("bbsList",resultSet);
		
		return "sw/bbs/bbsListView";
	}
	
	/**
	 * 게시글을 작성하는 페이지
	 * 
	 * @param mo
	 * @return 
	 */
	@RequestMapping(value="bbsPost.do", method = RequestMethod.GET)
	public String bbsPostForm(Model mo)
	{
		mo.addAttribute("BbsVO",new BbsVO());
		
		return "sw/bbs/bbsPost";
	}
	
	/**
	 * 게시글 처리를 담당하는 페이지, 작성자의 id는 세션으로부터 얻어온다.
	 * @param vo
	 * @param mo
	 * @param session
	 * @return 작성 성공시 게시판 리스트쪽으로 리다이렉트, 실패시
	 */
	@RequestMapping(value="bbsPostAction.do", method = RequestMethod.POST)
	public String bbsPostAction(@ModelAttribute("BbsVO") BbsVO vo , Model mo, HttpSession session)
	{
		UserVO login = (UserVO)session.getAttribute("LoginUser");

		try{
			vo.setUser_id(login.getUser_id());
			service.insert(vo);
		}catch(Exception e){
			e.printStackTrace();
			return "404";
		}
		return "redirect:bbsListView.do";
	}
	
	/**
	 * 특정 게시글을 검색하여 보여준다.
	 * @param mo
	 * @param req
	 * @return 쿼리스트링에 값이 없으면 0 으로 치환	
	 */
	@RequestMapping(value = "bbsView.do", method = RequestMethod.GET)
	public String bbsView(Model mo, HttpServletRequest req)
	{
		int id = Optional.ofNullable(req.getParameter("id"))
						 .map(Integer::parseInt)
						 .orElse(0);	// 값이 안들어 오면 0으로 치환

		BbsVO vo = new BbsVO();
		vo.setBbs_id(id);
		
		BbsVO resultSet = service.select(vo);
		mo.addAttribute("bbs",resultSet);
		return "sw/bbs/bbsView";
	}
	
	/**
	 * 게시글을 수정하는 메소드
	 * @param vo
	 * @param mo
	 * @return 수정 페이지
	 */
	@RequestMapping(value = "bbsEdit.do", method = RequestMethod.GET)
	public String bbsEdit(Model mo,HttpServletRequest req)
	{
		BbsVO select = new BbsVO();
		select.setBbs_id(Integer.parseInt(Optional.ofNullable(req.getParameter("id"))
												  .orElse("0")));
		BbsVO selected = service.select(select);
		mo.addAttribute("bbsEditVO",selected);
		
		return "sw/bbs/bbsEdit";
	}
	
	
	@RequestMapping(value = "bbsEditAction.do", method = RequestMethod.POST)
	public String bbsEditAction(@ModelAttribute("bbsEditVO") BbsVO vo, Model mo)
	{
		service.update(vo);
		
		return "redirect:bbsView.do?id=" + vo.getBbs_id();
	}
	
	
	@RequestMapping(value = "bbsDelete.do", method = RequestMethod.GET)
	public String bbsDeleteAction(BbsVO vo, Model mo, HttpServletRequest req,RedirectAttributes reDirAttr)
	{
		vo.setBbs_id((Integer.parseInt(Optional.ofNullable(req.getParameter("id"))
											   .orElse("0"))));
		
		try{
			service.delete(vo);
			reDirAttr.addFlashAttribute("status","alert alert-success");	 // 부트스트랩 속성값
			reDirAttr.addFlashAttribute("message",vo.getBbs_id() + "번 게시글 삭제에 성공하였습니다");
		}catch(Exception e){
			e.printStackTrace();
			reDirAttr.addFlashAttribute("status","alert alert-danger");	 // 부트스트랩 속성값
			reDirAttr.addFlashAttribute("message",vo.getBbs_id() + "번 게시글 삭제에 실패하였습니다");
		}
		
		
		return "redirect:bbsListView.do";
	}
}
