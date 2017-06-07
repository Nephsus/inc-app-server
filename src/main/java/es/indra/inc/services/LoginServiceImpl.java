package es.indra.inc.services;


import es.indra.inc.model.Employee;
import es.indra.itecban.interfaces.ItecbanConnectorRemote;


public class LoginService implements ILoginService {
	
	private ItecbanConnectorRemote itecbanConnector;
	

	@Override
	public Employee doAuthentication(String username, String password) {
		
		return null;
	}


	public ItecbanConnectorRemote getItecbanConnector() {
		return itecbanConnector;
	}


	public void setItecbanConnector(ItecbanConnectorRemote itecbanConnector) {
		this.itecbanConnector = itecbanConnector;
	}
	
	
	

}
