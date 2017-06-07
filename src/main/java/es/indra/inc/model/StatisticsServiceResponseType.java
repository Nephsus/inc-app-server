package es.indra.inc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticsServiceResponseType {
	
	
	@JsonProperty("statisticsServiceOutputType")
	private StatisticsServiceOutputType statisticsServiceOutputType;

	public StatisticsServiceOutputType getStatisticsServiceOutputType() {
		return statisticsServiceOutputType;
	}

	public void setStatisticsServiceOutputType(StatisticsServiceOutputType statisticsServiceOutputType) {
		this.statisticsServiceOutputType = statisticsServiceOutputType;
	}
	
	
	

}
