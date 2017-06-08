package es.indra.inc;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.indra.inc.model.Employee;
import es.indra.inc.model.LineChartData;
import es.indra.inc.model.StatisticsServiceOutputType;
import es.indra.inc.model.StatisticsServiceResponseType;



@RestController
@RequestMapping("/services/statistics")
public class StatisticsController {
	
	private static final Logger logger = LoggerFactory.getLogger(StatisticsController.class);
	
	@RequestMapping(method = RequestMethod.GET, value = "/getStadisticsResponse")
	public StatisticsServiceResponseType getStadisticsResponse(Authentication authentication){
		
		

		
		StatisticsServiceResponseType response = new StatisticsServiceResponseType();
		StatisticsServiceOutputType responseOut = new StatisticsServiceOutputType();
		LineChartData lineChartData = new LineChartData();
		LineChartData lineChartData2 = new LineChartData();
		LineChartData lineChartData3 = new LineChartData();
		
		List<Integer> data = new ArrayList<Integer>();
		
		data.add(0);
		data.add(33);
		data.add(68);
		data.add(89);
		data.add(65);
		data.add(32);
		data.add(56);
		data.add(89);
		data.add(70);
		data.add(1300);
		data.add(133);
		data.add(123);
		
List<Integer> data1 = new ArrayList<Integer>();
		
data1.add(1);
data1.add(33);
data1.add(68);
data1.add(200);
data1.add(250);
data1.add(32);
data1.add(56);
data1.add(89);
data1.add(99);
data1.add(12);
data1.add(5);
data1.add(234);

List<Integer> data2 = new ArrayList<Integer>();

data2.add(133);
data2.add(189);
data2.add(268);
data2.add(78);
data2.add(97);
data2.add(555);
data2.add(67);
data2.add(389);
data2.add(470);
data2.add(1005);
data2.add(34);
data2.add(55);
		
	
		lineChartData.setData(data);
		lineChartData.setLabel("Notificaciones email");
		lineChartData2.setData(data1);
		lineChartData2.setLabel("Notificaciones sms");
		lineChartData3.setData(data2);
		lineChartData3.setLabel("Notificaciones push");
		List<LineChartData> lineChartDataPrincipal = new ArrayList<LineChartData>();
		lineChartDataPrincipal.add(lineChartData);
		lineChartDataPrincipal.add(lineChartData2);
		lineChartDataPrincipal.add(lineChartData3);
		responseOut.setLineChartData(lineChartDataPrincipal);
		
		response.setStatisticsServiceOutputType(responseOut);
		
		
		
		return response;
	
	
	
	}
	
	
	

}
