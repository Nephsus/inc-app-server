package es.indra.inc.model;

import java.util.List;

public class RegisteredDevicesOutputType {
	
	private User user;
	private List<DevicesRegistered> devicesRegistered;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<DevicesRegistered> getDevicesRegistered() {
		return devicesRegistered;
	}
	public void setDevicesRegistered(List<DevicesRegistered> devicesRegistered) {
		this.devicesRegistered = devicesRegistered;
	}

}
