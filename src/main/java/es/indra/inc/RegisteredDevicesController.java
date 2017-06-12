package es.indra.inc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.indra.inc.model.DevicesRegistered;
import es.indra.inc.model.RegisteredDevicesOutputType;
import es.indra.inc.model.User;

@RestController
@RequestMapping("/services/registereddevices")
public class RegisteredDevicesController {
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/getDevices")
	public RegisteredDevicesOutputType getRegisteredDevicesByUser(String codeUser){
		
		RegisteredDevicesOutputType response = new RegisteredDevicesOutputType();
		List<DevicesRegistered> devices = new ArrayList<DevicesRegistered>();
		User user = new User();
		user.setCode("30966054G");
		user.setName("David");
		user.setLastName("Cava Jiménez");
		user.setDocumentID("30966054G");

		DevicesRegistered device = new DevicesRegistered();
				
		device.setDeviceType("iphone");	
		device.setPlatform("iOS 9.0");	
		device.setDischargeDate("10/10/2017");	
		device.setLastCheckDate("11/02/2017");	
		
		devices.add(device);
		
		device = new DevicesRegistered();
		
		device.setDeviceType("xiaomi");	
		device.setPlatform("Android 7.0");	
		device.setDischargeDate("10/10/2017");	
		device.setLastCheckDate("11/02/2017");	
		
		devices.add(device);
		
		device = new DevicesRegistered();
		
		device.setDeviceType("Galaxy s7");	
		device.setPlatform("Android 6");	
		device.setDischargeDate("10/10/2017");	
		device.setLastCheckDate("11/02/2017");	
		
		devices.add(device);
		
		response.setUser(user);
		response.setDevicesRegistered(devices);
		
		return response;
		
	}

}
