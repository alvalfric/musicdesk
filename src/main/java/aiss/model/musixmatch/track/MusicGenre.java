
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
    "music_genre_id",
    "music_genre_parent_id",
    "music_genre_name",
    "music_genre_name_extended",
    "music_genre_vanity"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class MusicGenre {

    @JsonProperty("music_genre_id")
    private Integer music_genre_id;
    @JsonProperty("music_genre_parent_id")
    private Integer music_genre_parent_id;
    @JsonProperty("music_genre_name")
    private String music_genre_name;
    @JsonProperty("music_genre_name_extended")
    private String music_genre_name_extended;
    @JsonProperty("music_genre_vanity")
    private String music_genre_vanity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("music_genre_id")
    public Integer getmusic_genre_id() {
        return music_genre_id;
    }

    @JsonProperty("music_genre_id")
    public void setmusic_genre_id(Integer music_genre_id) {
        this.music_genre_id = music_genre_id;
    }

    @JsonProperty("music_genre_parent_id")
    public Integer getmusic_genre_parent_id() {
        return music_genre_parent_id;
    }

    @JsonProperty("music_genre_parent_id")
    public void setmusic_genre_parent_id(Integer music_genre_parent_id) {
        this.music_genre_parent_id = music_genre_parent_id;
    }

    @JsonProperty("music_genre_name")
    public String getmusic_genre_name() {
        return music_genre_name;
    }

    @JsonProperty("music_genre_name")
    public void setmusic_genre_name(String music_genre_name) {
        this.music_genre_name = music_genre_name;
    }

    @JsonProperty("music_genre_name_extended")
    public String getmusic_genre_name_extended() {
        return music_genre_name_extended;
    }

    @JsonProperty("music_genre_name_extended")
    public void setmusic_genre_name_extended(String music_genre_name_extended) {
        this.music_genre_name_extended = music_genre_name_extended;
    }

    @JsonProperty("music_genre_vanity")
    public String getmusic_genre_vanity() {
        return music_genre_vanity;
    }

    @JsonProperty("music_genre_vanity")
    public void setmusic_genre_vanity(String music_genre_vanity) {
        this.music_genre_vanity = music_genre_vanity;
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
