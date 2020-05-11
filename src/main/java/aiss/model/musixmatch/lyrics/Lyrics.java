
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
	"lyrics_id", "explicit", "lyrics_body", "script_tracking_url", "pixel_tracking_url", "lyrics_copyright", "updated_time"
})
public class Lyrics {

	@JsonProperty("lyrics_id")
	private Integer				lyrics_id;
	@JsonProperty("explicit")
	private Integer				explicit;
	@JsonProperty("lyrics_body")
	private String				lyrics_body;
	@JsonProperty("script_tracking_url")
	private String				script_tracking_url;
	@JsonProperty("pixel_tracking_url")
	private String				pixel_tracking_url;
	@JsonProperty("lyrics_copyright")
	private String				lyrics_copyright;
	@JsonProperty("updated_time")
	private String				updated_time;
	@JsonIgnore
	private Map<String, Object>	additionalProperties	= new HashMap<String, Object>();


	@JsonProperty("lyrics_id")
	public Integer getlyrics_id() {
		return this.lyrics_id;
	}

	@JsonProperty("lyrics_id")
	public void setlyrics_id(final Integer lyrics_id) {
		this.lyrics_id = lyrics_id;
	}

	@JsonProperty("explicit")
	public Integer getExplicit() {
		return this.explicit;
	}

	@JsonProperty("explicit")
	public void setExplicit(final Integer explicit) {
		this.explicit = explicit;
	}

	@JsonProperty("lyrics_body")
	public String getlyrics_body() {
		return this.lyrics_body;
	}

	@JsonProperty("lyrics_body")
	public void setlyrics_body(final String lyrics_body) {
		this.lyrics_body = lyrics_body;
	}

	@JsonProperty("script_tracking_url")
	public String getscript_tracking_url() {
		return this.script_tracking_url;
	}

	@JsonProperty("script_tracking_url")
	public void setscript_tracking_url(final String script_tracking_url) {
		this.script_tracking_url = script_tracking_url;
	}

	@JsonProperty("pixel_tracking_url")
	public String getpixel_tracking_url() {
		return this.pixel_tracking_url;
	}

	@JsonProperty("pixel_tracking_url")
	public void setpixel_tracking_url(final String pixel_tracking_url) {
		this.pixel_tracking_url = pixel_tracking_url;
	}

	@JsonProperty("lyrics_copyright")
	public String getlyrics_copyright() {
		return this.lyrics_copyright;
	}

	@JsonProperty("lyrics_copyright")
	public void setlyrics_copyright(final String lyrics_copyright) {
		this.lyrics_copyright = lyrics_copyright;
	}

	@JsonProperty("updated_time")
	public String getupdated_time() {
		return this.updated_time;
	}

	@JsonProperty("updated_time")
	public void setupdated_time(final String updated_time) {
		this.updated_time = updated_time;
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
