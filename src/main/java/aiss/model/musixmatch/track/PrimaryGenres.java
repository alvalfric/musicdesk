
package aiss.model.musixmatch.track;

import java.util.HashMap;
import java.util.List;
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
    "music_genre_list"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class PrimaryGenres {

    @JsonProperty("music_genre_list")
    private List<MusicGenreList> music_genre_list = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("music_genre_list")
    public List<MusicGenreList> getmusic_genre_list() {
        return music_genre_list;
    }

    @JsonProperty("music_genre_list")
    public void setmusic_genre_list(List<MusicGenreList> music_genre_list) {
        this.music_genre_list = music_genre_list;
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
