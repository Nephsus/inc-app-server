package es.indra.inc.services;


import es.indra.inc.model.LoginInputType;
import es.indra.inc.model.LoginOutPutType;

public interface LoginService {
	public abstract LoginOutPutType execute(LoginInputType loginInputType);
}
