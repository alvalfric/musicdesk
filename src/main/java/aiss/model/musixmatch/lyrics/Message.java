
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
	"header", "body"
})
public class Message {

	@JsonProperty("header")
	private Header				header;
	@JsonProperty("body")
	private Body				body;
	@JsonIgnore
	private Map<String, Object>	additionalProperties	= new HashMap<String, Object>();


	@JsonProperty("header")
	public Header getHeader() {
		return this.header;
	}

	@JsonProperty("header")
	public void setHeader(final Header header) {
		this.header = header;
	}

	@JsonProperty("body")
	public Body getBody() {
		return this.body;
	}

	@JsonProperty("body")
	public void setBody(final Body body) {
		this.body = body;
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
