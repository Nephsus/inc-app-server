package es.indra.inc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.indra.inc.model.Employee;
import es.indra.inc.model.StatisticsServiceResponseType;


@RestController
@RequestMapping("/services/enviorementdash")
public class EnviorementDashController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/getEmployeeResponde")
	public Employee getEmployee(Authentication authentication){
		 return (Employee) authentication.getPrincipal();
	}

}
