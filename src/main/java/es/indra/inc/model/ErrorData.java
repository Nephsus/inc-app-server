package es.indra.inc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"errorText",
"errorFlag",
"errorType"
})

public class ErrorData {
	
	private String errorText;
	private Boolean errorFlag;
	private String errorType;
	
	public String getErrorText() {
		return errorText;
	}
	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}
	public Boolean getErrorFlag() {
		return errorFlag;
	}
	public void setErrorFlag(Boolean errorFlag) {
		this.errorFlag = errorFlag;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
	
	

}
