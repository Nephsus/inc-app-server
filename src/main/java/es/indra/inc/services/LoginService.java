package es.indra.inc.services;

import es.indra.inc.model.Employee;

public interface ILoginService {
	
	public abstract Employee doAuthentication(String username, String password);

}
