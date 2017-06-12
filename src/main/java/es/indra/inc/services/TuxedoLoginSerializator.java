package es.indra.inc.services;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;

import es.indra.inc.model.Employee;
import es.indra.inc.model.LoginInputType;
import es.indra.inc.model.LoginOutPutType;
import es.indra.inc.utils.Encriptacion;

public class TuxedoLoginSerializator implements ISerializator<String, LoginInputType,LoginOutPutType>{
	
	
	private String messageInvoke = "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?><INPSF><CABMEN TERMINAL=\"000010\" CODTX=\"200090\" NOMTX=\"GHAPERPT\" NUMSEC=\"0000000001\" TXM=\"0\"><USUA>SRNX</USUA></CABMEN><DATOS><EMPL>%s</EMPL><SECR>%s</SECR></DATOS></INPSF>";
	
	private static final Logger logger = LoggerFactory.getLogger(TuxedoLoginSerializator.class);
	
	
	public String serialize( LoginInputType inputObject){
		logger.debug("SERIALIZE");
		return String.format(getMessageInvoke(),
				inputObject.getUsername(), Encriptacion.tripleDesEncode( inputObject.getPassword() ));

	}
	
	
	
	public LoginOutPutType deserializer( String responseObject ){
		logger.debug("CAGO EN LA MAR");
		logger.debug("DESERIALIZE" + responseObject);
		if (responseObject.contains("<FORMATO CODIGO=\"SH0008\">")){
			
			throw new BadCredentialsException(StringUtils.substringBetween(StringUtils.substringBetween(responseObject,"<FORMATO CODIGO=\"SH0008\">", "</FORMATO>"),"<MSGT>","</MSGT>"));
			
		}
	
		if (responseObject.contains("<FORMATO CODIGO=\"ZC0726\">")){
				LoginOutPutType loginOutPutType = new LoginOutPutType();
				Employee employee = new Employee();
	
				employee.setName(StringUtils.substringBetween(responseObject, "<APEL>", "</APEL>"));
				employee.setTerminal(StringUtils.substringBetween(responseObject, "<TERM>", "</TERM>"));
				employee.setOficina(StringUtils.substringBetween(responseObject, "<OFIC>", "</OFIC>"));
				employee.setRol(StringUtils.substringBetween(responseObject, "<TEX2>", "</TEX2>"));
				
				loginOutPutType.setEmployee(employee);
				return loginOutPutType;
				
				}
		logger.debug("devuelvo nullllll");
		return null;

	}
	
	
	
	
	
	
	public String getMessageInvoke() {
		return messageInvoke;
	}


	public void setItecbanConnector(String messageInvoke) {
		this.messageInvoke = messageInvoke;
	}

}
