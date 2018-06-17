package my.android.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import my.sw.model.vo.UserVO;
import my.sw.service.CrudService;

@Controller
public class AndroidHomeController
{
	@Autowired
	CrudService<UserVO> userService; 
	
	@RequestMapping(value="/api/jsonTest.json", produces="application/json")
	public void greeting(UserVO vo, HttpServletResponse res)
	{
	   ObjectMapper mapper = new ObjectMapper();
	   List<UserVO> list = userService.selectList(vo);
	   UserVO user = list.get(0);
	   	try {
		   res.getWriter().print(mapper.writeValueAsString(user));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
