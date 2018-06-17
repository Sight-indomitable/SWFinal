package my.sw.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import my.sw.model.vo.UserVO;
import my.sw.service.CrudService;

@Controller
public class UserController
{
	@Autowired
	CrudService<UserVO> service; 
	
	// -----------------  Sign in operations ----------------------------
	
	@RequestMapping(value="signin.do", method = RequestMethod.GET)
	public String signinForm(Model mo)
	{
		mo.addAttribute("SigninVO",new UserVO());
		
		return "sw/user/signin";
	}
	
	@RequestMapping(value = "signinAction.do", method = RequestMethod.POST)
	public String insertUser(@ModelAttribute("SigninVO") UserVO vo, Model mo)
	{
		try{
			service.insert(vo);
		}catch(Exception e){
			e.printStackTrace();
			return "404";
		}
		return "../../index";
	}
	
	
	
	// -------------------- Login operations ----------------------------
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String loginForm(Model mo)
	{
		mo.addAttribute("LoginVO",new UserVO());
		
		return "sw/user/login";
	}
	
	@RequestMapping(value = "loginAction.do", method = RequestMethod.POST)
	public String loginAction(@ModelAttribute("LoginVO") UserVO vo, HttpSession session, RedirectAttributes reDirAttr)
	{
		
		UserVO user = service.select(vo);
								
		if(user == null)
		{
			reDirAttr.addFlashAttribute("status","alert alert-danger");	 // 부트스트랩 속성값
			reDirAttr.addFlashAttribute("message","로그인 실패, 다시 입력해주세요");
		}else{
			reDirAttr.addFlashAttribute("status","alert alert-success"); // 부트스트랩 속성값
			reDirAttr.addFlashAttribute("message","로그인 성공");
			session.setAttribute("LoginUser", user);
		}
		
		return "redirect:index.do";
	}
	
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logoutAction(HttpSession session, RedirectAttributes reDirAttr)
	{
		session.removeAttribute("LoginUser");
		reDirAttr.addFlashAttribute("status","alert alert-success"); // 부트스트랩 속성값
		reDirAttr.addFlashAttribute("message","로그아웃 성공");
		
		return "redirect:index.do";
	}
	

	
}
