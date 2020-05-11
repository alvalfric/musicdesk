
package aiss.model.eventful;

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
    "last_item",
    "total_items",
    "first_item",
    "page_number",
    "page_size",
    "page_items",
    "search_time",
    "page_count",
    "events"
})
public class EventSearch {

    @JsonProperty("last_item")
    private Object last_item;
    @JsonProperty("total_items")
    private String total_items;
    @JsonProperty("first_item")
    private Object first_item;
    @JsonProperty("page_number")
    private String page_number;
    @JsonProperty("page_size")
    private String page_size;
    @JsonProperty("page_items")
    private Object page_items;
    @JsonProperty("search_time")
    private String search_time;
    @JsonProperty("page_count")
    private String page_count;
    @JsonProperty("events")
    private Events events;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("last_item")
    public Object getlast_item() {
        return last_item;
    }

    @JsonProperty("last_item")
    public void setlast_item(Object last_item) {
        this.last_item = last_item;
    }

    @JsonProperty("total_items")
    public String gettotal_items() {
        return total_items;
    }

    @JsonProperty("total_items")
    public void settotal_items(String total_items) {
        this.total_items = total_items;
    }

    @JsonProperty("first_item")
    public Object getfirst_item() {
        return first_item;
    }

    @JsonProperty("first_item")
    public void setfirst_item(Object first_item) {
        this.first_item = first_item;
    }

    @JsonProperty("page_number")
    public String getpage_number() {
        return page_number;
    }

    @JsonProperty("page_number")
    public void setpage_number(String page_number) {
        this.page_number = page_number;
    }

    @JsonProperty("page_size")
    public String getpage_size() {
        return page_size;
    }

    @JsonProperty("page_size")
    public void setpage_size(String page_size) {
        this.page_size = page_size;
    }

    @JsonProperty("page_items")
    public Object getpage_items() {
        return page_items;
    }

    @JsonProperty("page_items")
    public void setpage_items(Object page_items) {
        this.page_items = page_items;
    }

    @JsonProperty("search_time")
    public String getsearch_time() {
        return search_time;
    }

    @JsonProperty("search_time")
    public void setsearch_time(String search_time) {
        this.search_time = search_time;
    }

    @JsonProperty("page_count")
    public String getpage_count() {
        return page_count;
    }

    @JsonProperty("page_count")
    public void setpage_count(String page_count) {
        this.page_count = page_count;
    }

    @JsonProperty("events")
    public Events getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(Events events) {
        this.events = events;
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
