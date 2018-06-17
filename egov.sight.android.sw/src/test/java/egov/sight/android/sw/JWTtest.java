package egov.sight.android.sw;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import my.sw.controller.BbsController;

public class JWTtest {
	
	Logger logger = LogManager.getLogger(JWTtest.class.getName());
	
	@Test
	public void test() throws UnsupportedEncodingException
	{
		
		String jwt = Jwts.builder()
						 .setHeaderParam("typ", "JWT")
						 .claim("id","sight")
						 .claim("pw", "bksul40")
						 .signWith(SignatureAlgorithm.HS256, "secret".getBytes("UTF-8"))
						 .compact();
						 /*.setSubject("")
						 .*/
		
		logger.debug("\n\n------------------------------\n\n" + jwt + "\n\n----------------------------------\n\n");
		
		Jws<Claims> claims = Jwts.parser()
							 .setSigningKey("secret".getBytes("UTF-8"))
							 .parseClaimsJws(jwt);
	
		String scope = (String) claims.getBody().get("name");
		
		logger.debug(claims);
	}
}








