package es.indra.inc.services;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


	public Object performRemoteOperation( RemotingOperationBean remoteOperation ){
		Object output = null;
		logger.debug("david performRemoteOperation");
         try {
                Object target = services.get("login");
                Method method = target.getClass().getMethod("execute", 
                		new Class[] { remoteOperation.getInputObject().getClass() });
                output = ReflectionUtils.invokeMethod(method, 
                		target, new Object[] { remoteOperation.getInputObject() });
        
         } catch (Exception e) {
        	 logger.error("david performRemoteOperation: " + e.getMessage(), e);
         }
         
         return output;

	}
	
	
	
	

}
