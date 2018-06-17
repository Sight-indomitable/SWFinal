package my.android.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import my.android.model.vo.ClientVO;
import my.sw.service.CrudService;

@Controller
public class ClientController
{
	@Autowired
	CrudService<ClientVO> service;
	
	@RequestMapping(value="/api/joinClient.json", produces="application/json", method = RequestMethod.POST)
	public void joinClient(@RequestBody String input ,HttpServletResponse res) throws IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter html = res.getWriter();
		try {
			ClientVO vo = mapper.readValue(input, ClientVO.class);
			service.insert(vo);
			html.print("{\"result\" : \"success\" }");			
		} catch (Exception e) {
			e.printStackTrace();
			html.print("{\"result\" : " + e.getMessage() +" } \n " + input);
		}
	}
	
	/**
	 * 안드로이드 로그인 로그인 성공시 웹페이지에 JWT를  리턴해준다
	 * @param input {id : ?, pw : ?} 형식으로 들어오는 json 
	 * @param res
	 * @throws IOException
	 */
	@RequestMapping(value="/api/login.json",produces="application/json", method = RequestMethod.POST)
	public void loginClient(@RequestBody String input ,HttpServletResponse res) throws IOException
	{
		JSONParser jsonParser = new JSONParser();
		PrintWriter html = res.getWriter();
		try{
			JSONObject json = (JSONObject)jsonParser.parse(input);
			ClientVO vo = new ClientVO();
			vo.setId(json.get("id").toString());		
			vo.setPw(json.get("pw").toString());
			
			ClientVO result = service.select(vo);
			
			if(result != null)
			{
				html.print("{\"result\" : \"success\"," +"\"JWT\" : \""+ jwtBuilder(vo)+"\"}");
			}else{
				html.print("{\"result\" : \"fail\"}" );
			}
		}catch(Exception e){
			e.printStackTrace();
			html.print("{\"result\" : \""+ e.getMessage() + "\n" + 
										   e.toString()   + "\n" +
										   e.getClass().getName() + "\n" +
										   input + "\"}" );
		}
	}
	
	
	
	private String jwtBuilder(ClientVO vo)
	{
		try {
			String result = Jwts.builder()
							    .setHeaderParam("typ", "JWT")
							    .claim("id",vo.getId())
							    .claim("pw", vo.getPw())
							    .signWith(SignatureAlgorithm.HS256, "secret".getBytes("UTF-8"))
							    .compact();
			
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}