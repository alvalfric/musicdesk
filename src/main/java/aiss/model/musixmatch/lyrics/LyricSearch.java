
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
	"message"
})
public class LyricSearch {

	@JsonProperty("message")
	private Message				message;
	@JsonIgnore
	private Map<String, Object>	additionalProperties	= new HashMap<String, Object>();


	@JsonProperty("message")
	public Message getMessage() {
		return this.message;
	}

	@JsonProperty("message")
	public void setMessage(final Message message) {
		this.message = message;
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
