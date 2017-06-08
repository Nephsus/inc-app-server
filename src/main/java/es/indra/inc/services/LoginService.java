package es.indra.inc.services;

import es.indra.inc.model.Employee;

public interface LoginService {
	
	public abstract Employee doAuthentication(String username, String password);

}
