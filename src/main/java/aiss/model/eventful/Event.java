
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
    "watching_count",
    "olson_path",
    "calendar_count",
    "comment_count",
    "region_abbr",
    "postal_code",
    "going_count",
    "all_day",
    "latitude",
    "groups",
    "url",
    "id",
    "privacy",
    "city_name",
    "link_count",
    "longitude",
    "country_name",
    "country_abbr",
    "region_name",
    "start_time",
    "tz_id",
    "description",
    "modified",
    "venue_display",
    "tz_country",
    "performers",
    "title",
    "venue_address",
    "geocode_type",
    "tz_olson_path",
    "recur_string",
    "calendars",
    "owner",
    "going",
    "country_abbr2",
    "image",
    "created",
    "venue_id",
    "tz_city",
    "stop_time",
    "venue_name",
    "venue_url"
})
public class Event {

    @JsonProperty("watching_count")
    private Object watching_count;
    @JsonProperty("olson_path")
    private String olson_path;
    @JsonProperty("calendar_count")
    private Object calendar_count;
    @JsonProperty("comment_count")
    private Object comment_count;
    @JsonProperty("region_abbr")
    private String region_abbr;
    @JsonProperty("postal_code")
    private Object postal_code;
    @JsonProperty("going_count")
    private Object going_count;
    @JsonProperty("all_day")
    private String all_day;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("groups")
    private Object groups;
    @JsonProperty("url")
    private String url;
    @JsonProperty("id")
    private String id;
    @JsonProperty("privacy")
    private String privacy;
    @JsonProperty("city_name")
    private String city_name;
    @JsonProperty("link_count")
    private Object link_count;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("country_name")
    private String country_name;
    @JsonProperty("country_abbr")
    private String country_abbr;
    @JsonProperty("region_name")
    private String region_name;
    @JsonProperty("start_time")
    private String start_time;
    @JsonProperty("tz_id")
    private Object tz_id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("modified")
    private String modified;
    @JsonProperty("venue_display")
    private String venue_display;
    @JsonProperty("tz_country")
    private Object tz_country;
    @JsonProperty("performers")
    private Object performers;
    @JsonProperty("title")
    private String title;
    @JsonProperty("venue_address")
    private String venue_address;
    @JsonProperty("geocode_type")
    private String geocode_type;
    @JsonProperty("tz_olson_path")
    private String tz_olson_path;
    @JsonProperty("recur_string")
    private Object recur_string;
    @JsonProperty("calendars")
    private Object calendars;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("going")
    private Object going;
    @JsonProperty("country_abbr2")
    private String country_abbr2;
    @JsonProperty("image")
    private Object image;
    @JsonProperty("created")
    private String created;
    @JsonProperty("venue_id")
    private String venue_id;
    @JsonProperty("tz_city")
    private Object tz_city;
    @JsonProperty("stop_time")
    private Object stop_time;
    @JsonProperty("venue_name")
    private String venue_name;
    @JsonProperty("venue_url")
    private String venue_url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("watching_count")
    public Object getwatching_count() {
        return watching_count;
    }

    @JsonProperty("watching_count")
    public void setwatching_count(Object watching_count) {
        this.watching_count = watching_count;
    }

    @JsonProperty("olson_path")
    public String getolson_path() {
        return olson_path;
    }

    @JsonProperty("olson_path")
    public void setolson_path(String olson_path) {
        this.olson_path = olson_path;
    }

    @JsonProperty("calendar_count")
    public Object getcalendar_count() {
        return calendar_count;
    }

    @JsonProperty("calendar_count")
    public void setcalendar_count(Object calendar_count) {
        this.calendar_count = calendar_count;
    }

    @JsonProperty("comment_count")
    public Object getcomment_count() {
        return comment_count;
    }

    @JsonProperty("comment_count")
    public void setcomment_count(Object comment_count) {
        this.comment_count = comment_count;
    }

    @JsonProperty("region_abbr")
    public String getregion_abbr() {
        return region_abbr;
    }

    @JsonProperty("region_abbr")
    public void setregion_abbr(String region_abbr) {
        this.region_abbr = region_abbr;
    }

    @JsonProperty("postal_code")
    public Object getpostal_code() {
        return postal_code;
    }

    @JsonProperty("postal_code")
    public void setpostal_code(Object postal_code) {
        this.postal_code = postal_code;
    }

    @JsonProperty("going_count")
    public Object getgoing_count() {
        return going_count;
    }

    @JsonProperty("going_count")
    public void setgoing_count(Object going_count) {
        this.going_count = going_count;
    }

    @JsonProperty("all_day")
    public String getall_day() {
        return all_day;
    }

    @JsonProperty("all_day")
    public void setall_day(String all_day) {
        this.all_day = all_day;
    }

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("groups")
    public Object getGroups() {
        return groups;
    }

    @JsonProperty("groups")
    public void setGroups(Object groups) {
        this.groups = groups;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("privacy")
    public String getPrivacy() {
        return privacy;
    }

    @JsonProperty("privacy")
    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    @JsonProperty("city_name")
    public String getcity_name() {
        return city_name;
    }

    @JsonProperty("city_name")
    public void setcity_name(String city_name) {
        this.city_name = city_name;
    }

    @JsonProperty("link_count")
    public Object getlink_count() {
        return link_count;
    }

    @JsonProperty("link_count")
    public void setlink_count(Object link_count) {
        this.link_count = link_count;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("country_name")
    public String getcountry_name() {
        return country_name;
    }

    @JsonProperty("country_name")
    public void setcountry_name(String country_name) {
        this.country_name = country_name;
    }

    @JsonProperty("country_abbr")
    public String getcountry_abbr() {
        return country_abbr;
    }

    @JsonProperty("country_abbr")
    public void setcountry_abbr(String country_abbr) {
        this.country_abbr = country_abbr;
    }

    @JsonProperty("region_name")
    public String getregion_name() {
        return region_name;
    }

    @JsonProperty("region_name")
    public void setregion_name(String region_name) {
        this.region_name = region_name;
    }

    @JsonProperty("start_time")
    public String getstart_time() {
        return start_time;
    }

    @JsonProperty("start_time")
    public void setstart_time(String start_time) {
        this.start_time = start_time;
    }

    @JsonProperty("tz_id")
    public Object gettz_id() {
        return tz_id;
    }

    @JsonProperty("tz_id")
    public void settz_id(Object tz_id) {
        this.tz_id = tz_id;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("modified")
    public String getModified() {
        return modified;
    }

    @JsonProperty("modified")
    public void setModified(String modified) {
        this.modified = modified;
    }

    @JsonProperty("venue_display")
    public String getvenue_display() {
        return venue_display;
    }

    @JsonProperty("venue_display")
    public void setvenue_display(String venue_display) {
        this.venue_display = venue_display;
    }

    @JsonProperty("tz_country")
    public Object gettz_country() {
        return tz_country;
    }

    @JsonProperty("tz_country")
    public void settz_country(Object tz_country) {
        this.tz_country = tz_country;
    }

    @JsonProperty("performers")
    public Object getPerformers() {
        return performers;
    }

    @JsonProperty("performers")
    public void setPerformers(Object performers) {
        this.performers = performers;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("venue_address")
    public String getvenue_address() {
        return venue_address;
    }

    @JsonProperty("venue_address")
    public void setvenue_address(String venue_address) {
        this.venue_address = venue_address;
    }

    @JsonProperty("geocode_type")
    public String getgeocode_type() {
        return geocode_type;
    }

    @JsonProperty("geocode_type")
    public void setgeocode_type(String geocode_type) {
        this.geocode_type = geocode_type;
    }

    @JsonProperty("tz_olson_path")
    public String gettz_olson_path() {
        return tz_olson_path;
    }

    @JsonProperty("tz_olson_path")
    public void settz_olson_path(String tz_olson_path) {
        this.tz_olson_path = tz_olson_path;
    }

    @JsonProperty("recur_string")
    public Object getrecur_string() {
        return recur_string;
    }

    @JsonProperty("recur_string")
    public void setrecur_string(Object recur_string) {
        this.recur_string = recur_string;
    }

    @JsonProperty("calendars")
    public Object getCalendars() {
        return calendars;
    }

    @JsonProperty("calendars")
    public void setCalendars(Object calendars) {
        this.calendars = calendars;
    }

    @JsonProperty("owner")
    public String getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @JsonProperty("going")
    public Object getGoing() {
        return going;
    }

    @JsonProperty("going")
    public void setGoing(Object going) {
        this.going = going;
    }

    @JsonProperty("country_abbr2")
    public String getcountry_abbr2() {
        return country_abbr2;
    }

    @JsonProperty("country_abbr2")
    public void setcountry_abbr2(String country_abbr2) {
        this.country_abbr2 = country_abbr2;
    }

    @JsonProperty("image")
    public Object getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Object image) {
        this.image = image;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("venue_id")
    public String getvenue_id() {
        return venue_id;
    }

    @JsonProperty("venue_id")
    public void setvenue_id(String venue_id) {
        this.venue_id = venue_id;
    }

    @JsonProperty("tz_city")
    public Object gettz_city() {
        return tz_city;
    }

    @JsonProperty("tz_city")
    public void settz_city(Object tz_city) {
        this.tz_city = tz_city;
    }

    @JsonProperty("stop_time")
    public Object getstop_time() {
        return stop_time;
    }

    @JsonProperty("stop_time")
    public void setstop_time(Object stop_time) {
        this.stop_time = stop_time;
    }

    @JsonProperty("venue_name")
    public String getvenue_name() {
        return venue_name;
    }

    @JsonProperty("venue_name")
    public void setvenue_name(String venue_name) {
        this.venue_name = venue_name;
    }

    @JsonProperty("venue_url")
    public String getvenue_url() {
        return venue_url;
    }

    @JsonProperty("venue_url")
    public void setvenue_url(String venue_url) {
        this.venue_url = venue_url;
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
