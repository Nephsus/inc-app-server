package es.indra.inc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"errorData"
})
public class HeaderData {
	
	private ErrorData errorData;

	public ErrorData getErrorData() {
		return errorData;
	}

	public void setErrorData(ErrorData errorData) {
		this.errorData = errorData;
	}
	
	

}
