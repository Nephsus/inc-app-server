package es.indra.inc.services;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

import es.indra.inc.HomeController;
import es.indra.inc.model.Employee;
import es.indra.inc.utils.Encriptacion;
import es.indra.itecban.errors.ConnectorException;
import es.indra.itecban.interfaces.ItecbanConnectorRemote;


public class LoginServiceImpl implements LoginService {
	
	private ItecbanConnectorRemote itecbanConnector;
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Override
	public Employee doAuthentication(String username, String password) throws AuthenticationException {
		/*String response =  null;
		
		try {
			 response = itecbanConnector.send("GHAPERPT", "000010", "X", "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?><INPSF><CABMEN TERMINAL=\"000010\" CODTX=\"200090\" NOMTX=\"GHAPERPT\" NUMSEC=\"0000000001\" TXM=\"0\"><USUA>SRNX</USUA></CABMEN><DATOS><EMPL>" + username + "</EMPL><SECR>" + Encriptacion.tripleDesEncode(password)    + "</SECR></DATOS></INPSF>");
		
		} catch (ConnectorException e) {
			logger.debug("VAMOSS RESPUESTA:" + e.getMessage(), e);
			e.printStackTrace();
		}
			logger.debug("VAMOSS RESPUESTA:" + response);
			
			if (response.contains("<FORMATO CODIGO=\"SH0008\">")){
				
				throw new BadCredentialsException(StringUtils.substringBetween(StringUtils.substringBetween(response,"<FORMATO CODIGO=\"SH0008\">", "</FORMATO>"),"<MSGT>","</MSGT>"));
				
			}
		
			if (response.contains("<FORMATO CODIGO=\"ZC0726\">")){
					Employee employee = new Employee();
		
					employee.setName(StringUtils.substringBetween(response, "<APEL>", "</APEL>"));
					employee.setTerminal(StringUtils.substringBetween(response, "<TERM>", "</TERM>"));
					employee.setOficina(StringUtils.substringBetween(response, "<OFIC>", "</OFIC>"));
					employee.setRol(StringUtils.substringBetween(response, "<TEX2>", "</TEX2>"));
					
					
					return employee;
			}*/
		
		Employee employee = new Employee();
		
		employee.setName("David Cava");
		employee.setTerminal("8001");
		employee.setOficina("9999");
		employee.setRol("OPERADOR");
		
		return employee;
	}


	public ItecbanConnectorRemote getItecbanConnector() {
		return itecbanConnector;
	}


	public void setItecbanConnector(ItecbanConnectorRemote itecbanConnector) {
		this.itecbanConnector = itecbanConnector;
	}
	
	
	

}
