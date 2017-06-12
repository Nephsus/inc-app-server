package es.indra.inc.services;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.indra.inc.model.LoginInputType;
import es.indra.inc.model.LoginOutPutType;
import es.indra.inc.provider.ItecbanProvider;
import es.indra.inc.serializator.Serializator;



public class LoginServiceImpl extends ParentService implements LoginService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	private ItecbanProvider provider;
	
	private Serializator<Object, LoginInputType, LoginOutPutType> serializator;
	private String serviceName;
	
	
	


	public ItecbanProvider getProvider() {
		return provider;
	}

	public void setProvider(ItecbanProvider provider) {
		this.provider = provider;
	}


	@Override
	public LoginOutPutType execute(LoginInputType loginInputType) throws Exception {
		   logger.debug("ME EJECUTO");
			return serializator.deserializer(
					   provider.performInvoke( new Object[]{ getServiceName(),"000010", serializator.serialize(loginInputType) } ));
		
		
	}

	public Serializator<Object, LoginInputType, LoginOutPutType> getSerializator() {
		return serializator;
	}


	public void setSerializator(Serializator<Object, LoginInputType, LoginOutPutType> serializator) {
		this.serializator = serializator;
	}



	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	


	

	

}
