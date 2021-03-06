package es.indra.inc.model;


	
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	import com.fasterxml.jackson.annotation.JsonAnyGetter;
	import com.fasterxml.jackson.annotation.JsonAnySetter;
	import com.fasterxml.jackson.annotation.JsonIgnore;
	import com.fasterxml.jackson.annotation.JsonInclude;
	import com.fasterxml.jackson.annotation.JsonProperty;
	import com.fasterxml.jackson.annotation.JsonPropertyOrder;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"data",
	"label"
	})
	public class LineChartData  {

	@JsonProperty("data")
	private List<Integer> data = null;
	@JsonProperty("label")
	private String label;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("data")
	public List<Integer> getData() {
	return data;
	}

	@JsonProperty("data")
	public void setData(List<Integer> data) {
	this.data = data;
	}

	@JsonProperty("label")
	public String getLabel() {
	return label;
	}

	@JsonProperty("label")
	public void setLabel(String label) {
	this.label = label;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

	}
	
	



