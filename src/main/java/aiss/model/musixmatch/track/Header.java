
package aiss.model.musixmatch.track;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status_code",
    "execute_time",
    "available"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Header {

    @JsonProperty("status_code")
    private Integer status_code;
    @JsonProperty("execute_time")
    private Double execute_time;
    @JsonProperty("available")
    private Integer available;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("status_code")
    public Integer getStatus_code() {
        return status_code;
    }

    @JsonProperty("status_code")
    public void setstatus_code(Integer status_code) {
        this.status_code = status_code;
    }

    @JsonProperty("execute_time")
    public Double getexecute_time() {
        return execute_time;
    }

    @JsonProperty("execute_time")
    public void setexecute_time(Double execute_time) {
        this.execute_time = execute_time;
    }

    @JsonProperty("available")
    public Integer getAvailable() {
        return available;
    }

    @JsonProperty("available")
    public void setAvailable(Integer available) {
        this.available = available;
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
