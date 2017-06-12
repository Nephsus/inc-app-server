package es.indra.inc.services;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.ReflectionUtils;

import es.indra.inc.model.RemotingOperationBean;

public class BusinessOperationRouter {
	
	private HashMap<String, ParentService> services;
	
	private static final Logger logger = LoggerFactory.getLogger(BusinessOperationRouter.class);

	public HashMap<String, ParentService> getServices() {
		return services;
	}




	public void setServices(HashMap<String, ParentService> services) {
		this.services = services;
	}


	public Object performRemoteOperation( RemotingOperationBean remoteOperation ) throws AuthenticationException  {
		Object output = null;
		
		try {
                Object target = services.get( remoteOperation.getOperation() );
                Method method = null;
				
					method = target.getClass().getMethod("execute", 
							new Class[] { remoteOperation.getInputObject().getClass() });
				
                output = ReflectionUtils.invokeMethod(method, 
                		target, new Object[] { remoteOperation.getInputObject() });
                
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			throw new AuthenticationServiceException( e.getMessage() );
		} 
         return output;

	}
	
	
	
	

}
