package es.indra.inc.security;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class IncAuthenticationProvider implements AuthenticationProvider {
	
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        if( "a".equals(name) && "a".equals(password) ){
	        ArrayList<SimpleGrantedAuthority> au  = new ArrayList<SimpleGrantedAuthority>();
	        SimpleGrantedAuthority sg = new SimpleGrantedAuthority("ROLE_USER");
	        au.add(sg);
	        
	        return new UsernamePasswordAuthenticationToken(name, password, au);
	        
	        
        }
        
        return  null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		
		return true;
	}

}
