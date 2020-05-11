
package aiss.model.musixmatch.lyrics;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"status_code", "execute_time"
})
public class Header {

	@JsonProperty("status_code")
	private Integer				status_code;
	@JsonProperty("execute_time")
	private Double				execute_time;
	@JsonIgnore
	private Map<String, Object>	additionalProperties	= new HashMap<String, Object>();


	@JsonProperty("status_code")
	public Integer getstatus_code() {
		return this.status_code;
	}

	@JsonProperty("status_code")
	public void setstatus_code(final Integer status_code) {
		this.status_code = status_code;
	}

	@JsonProperty("execute_time")
	public Double getexecute_time() {
		return this.execute_time;
	}

	@JsonProperty("execute_time")
	public void setexecute_time(final Double execute_time) {
		this.execute_time = execute_time;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(final String name, final Object value) {
		this.additionalProperties.put(name, value);
	}

}
