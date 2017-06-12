package es.indra.inc.security;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import es.indra.inc.model.LoginInputType;
import es.indra.inc.model.RemotingOperationBean;
import es.indra.inc.services.BusinessOperationRouter;

public class IncAuthenticationProvider implements AuthenticationProvider {
	
	private BusinessOperationRouter businessOperationRouter;

	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        LoginInputType loginInputType = new LoginInputType();
        loginInputType.setUsername(name);
        loginInputType.setPassword(password);
        
       //if( "a".equals(name) && "a".equals(password) ){
	        ArrayList<SimpleGrantedAuthority> au  = new ArrayList<SimpleGrantedAuthority>();
	        SimpleGrantedAuthority sg = new SimpleGrantedAuthority("ROLE_USER");
	        au.add(sg);
	        
	       
	        
	        RemotingOperationBean remotingOperationBean = new RemotingOperationBean();
	        
	        remotingOperationBean.setInputObject(loginInputType);
	        remotingOperationBean.setOperation("login" );
	        return new UsernamePasswordAuthenticationToken(businessOperationRouter.performRemoteOperation(remotingOperationBean), password, au);
	        
	        
        //}
        
      //  return  null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		
		return true;
	}

	public BusinessOperationRouter getBusinessOperationRouter() {
		return businessOperationRouter;
	}

	public void setBusinessOperationRouter(BusinessOperationRouter businessOperationRouter) {
		this.businessOperationRouter = businessOperationRouter;
	}

}
