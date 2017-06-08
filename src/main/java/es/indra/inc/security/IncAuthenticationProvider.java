package es.indra.inc.security;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import es.indra.inc.services.LoginService;

public class IncAuthenticationProvider implements AuthenticationProvider {
	
	private LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        
       ;
        
       //if( "a".equals(name) && "a".equals(password) ){
	        ArrayList<SimpleGrantedAuthority> au  = new ArrayList<SimpleGrantedAuthority>();
	        SimpleGrantedAuthority sg = new SimpleGrantedAuthority("ROLE_USER");
	        au.add(sg);
	        
	        return new UsernamePasswordAuthenticationToken(loginService.doAuthentication(name, password), password, au);
	        
	        
        //}
        
      //  return  null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		
		return true;
	}

}
