package es.indra.inc.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.indra.inc.services.LoginServiceImpl;
import es.indra.itecban.errors.ConnectorException;
import es.indra.itecban.interfaces.ItecbanConnectorRemote;

public class ItecbanTuxedoProvider implements ItecbanProvider {
	
	
	private ItecbanConnectorRemote itecbanConnector;
	private String channel;
	
	private static final Logger logger = LoggerFactory.getLogger(ItecbanTuxedoProvider.class);

	public ItecbanConnectorRemote getItecbanConnector() {
		return itecbanConnector;
	}

	public void setItecbanConnector(ItecbanConnectorRemote itecbanConnector) {
		this.itecbanConnector = itecbanConnector;
	}

	@Override
	public String performInvoke(Object[] inputObject) throws ConnectorException {
		// TODO Auto-generated method stub
		logger.debug("Voy a llamar");
		String response = itecbanConnector.send((String)inputObject[0], (String)inputObject[1], getChannel(), (String)inputObject[2]);
		logger.debug("Respuesta tuxedo:" + response);
	
		return response;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	
	
	
	
	

}
