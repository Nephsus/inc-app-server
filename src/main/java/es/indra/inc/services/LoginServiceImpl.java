package es.indra.inc.services;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import es.indra.inc.model.Employee;
import es.indra.inc.model.LoginInputType;
import es.indra.inc.model.LoginOutPutType;
import es.indra.inc.provider.ItecbanProvider;



public class LoginServiceImpl extends ParentService implements LoginService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	private ItecbanProvider provider;
	
	private ISerializator<Object, LoginInputType, LoginOutPutType> serializator;

	public ItecbanProvider getProvider() {
		return provider;
	}

	public void setProvider(ItecbanProvider provider) {
		this.provider = provider;
	}


	@Override
	public LoginOutPutType execute(LoginInputType loginInputType) {
		   logger.debug("ME EJECUTO");

		   try {
			return serializator.deserializer(
					   provider.performInvoke( new Object[]{"GHAPERPT","000010", "X",  serializator.serialize(loginInputType) } ));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug("David error:" + e.getMessage(),e);
			e.printStackTrace();
		}
		   
		   logger.debug("DEVUELVONULL");
		return null;
		
	}

	public ISerializator<Object, LoginInputType, LoginOutPutType> getSerializator() {
		return serializator;
	}


	public void setSerializator(ISerializator<Object, LoginInputType, LoginOutPutType> serializator) {
		this.serializator = serializator;
	}


	

	


	

	

}
