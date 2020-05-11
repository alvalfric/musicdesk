
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
    "track_id",
    "track_name",
    "track_name_translation_list",
    "track_rating",
    "commontrack_id",
    "instrumental",
    "explicit",
    "has_lyrics",
    "has_subtitles",
    "has_richsync",
    "num_favourite",
    "album_id",
    "album_name",
    "artist_id",
    "artist_name",
    "track_share_url",
    "track_edit_url",
    "restricted",
    "updated_time",
    "primary_genres"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Track {

    @JsonProperty("track_id")
    private Integer track_id;
    @JsonProperty("track_name")
    private String track_name;
    @JsonProperty("track_name_translation_list")
    private List<Object> track_name_translation_list = null;
    @JsonProperty("track_rating")
    private Integer track_rating;
    @JsonProperty("commontrack_id")
    private Integer commontrack_id;
    @JsonProperty("instrumental")
    private Integer instrumental;
    @JsonProperty("explicit")
    private Integer explicit;
    @JsonProperty("has_lyrics")
    private Integer has_lyrics;
    @JsonProperty("has_subtitles")
    private Integer has_subtitles;
    @JsonProperty("has_richsync")
    private Integer has_richsync;
    @JsonProperty("num_favourite")
    private Integer num_favourite;
    @JsonProperty("album_id")
    private Integer album_id;
    @JsonProperty("album_name")
    private String album_name;
    @JsonProperty("artist_id")
    private Integer artist_id;
    @JsonProperty("artist_name")
    private String artist_name;
    @JsonProperty("track_share_url")
    private String track_share_url;
    @JsonProperty("track_edit_url")
    private String track_edit_url;
    @JsonProperty("restricted")
    private Integer restricted;
    @JsonProperty("updated_time")
    private String updated_time;
    @JsonProperty("primary_genres")
    private PrimaryGenres primary_genres;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("track_id")
    public Integer gettrack_id() {
        return track_id;
    }

    @JsonProperty("track_id")
    public void settrack_id(Integer track_id) {
        this.track_id = track_id;
    }

    @JsonProperty("track_name")
    public String gettrack_name() {
        return track_name;
    }

    @JsonProperty("track_name")
    public void settrack_name(String track_name) {
        this.track_name = track_name;
    }

    @JsonProperty("track_name_translation_list")
    public List<Object> gettrack_name_translation_list() {
        return track_name_translation_list;
    }

    @JsonProperty("track_name_translation_list")
    public void settrack_name_translation_list(List<Object> track_name_translation_list) {
        this.track_name_translation_list = track_name_translation_list;
    }

    @JsonProperty("track_rating")
    public Integer gettrack_rating() {
        return track_rating;
    }

    @JsonProperty("track_rating")
    public void settrack_rating(Integer track_rating) {
        this.track_rating = track_rating;
    }

    @JsonProperty("commontrack_id")
    public Integer getcommontrack_id() {
        return commontrack_id;
    }

    @JsonProperty("commontrack_id")
    public void setcommontrack_id(Integer commontrack_id) {
        this.commontrack_id = commontrack_id;
    }

    @JsonProperty("instrumental")
    public Integer getinstrumental() {
        return instrumental;
    }

    @JsonProperty("instrumental")
    public void setinstrumental(Integer instrumental) {
        this.instrumental = instrumental;
    }

    @JsonProperty("explicit")
    public Integer getexplicit() {
        return explicit;
    }

    @JsonProperty("explicit")
    public void setexplicit(Integer explicit) {
        this.explicit = explicit;
    }

    @JsonProperty("has_lyrics")
    public Integer gethas_lyrics() {
        return has_lyrics;
    }

    @JsonProperty("has_lyrics")
    public void sethas_lyrics(Integer has_lyrics) {
        this.has_lyrics = has_lyrics;
    }

    @JsonProperty("has_subtitles")
    public Integer gethas_subtitles() {
        return has_subtitles;
    }

    @JsonProperty("has_subtitles")
    public void sethas_subtitles(Integer has_subtitles) {
        this.has_subtitles = has_subtitles;
    }

    @JsonProperty("has_richsync")
    public Integer gethas_richsync() {
        return has_richsync;
    }

    @JsonProperty("has_richsync")
    public void sethas_richsync(Integer has_richsync) {
        this.has_richsync = has_richsync;
    }

    @JsonProperty("num_favourite")
    public Integer getnum_favourite() {
        return num_favourite;
    }

    @JsonProperty("num_favourite")
    public void sethum_favourite(Integer num_favourite) {
        this.num_favourite = num_favourite;
    }

    @JsonProperty("album_id")
    public Integer getalbum_id() {
        return album_id;
    }

    @JsonProperty("album_id")
    public void setalbum_id(Integer album_id) {
        this.album_id = album_id;
    }

    @JsonProperty("album_name")
    public String getalbum_name() {
        return album_name;
    }

    @JsonProperty("album_name")
    public void setalbum_name(String album_name) {
        this.album_name = album_name;
    }

    @JsonProperty("artist_id")
    public Integer getartist_id() {
        return artist_id;
    }

    @JsonProperty("artist_id")
    public void setartist_id(Integer artist_id) {
        this.artist_id = artist_id;
    }

    @JsonProperty("artist_name")
    public String getartist_name() {
        return artist_name;
    }

    @JsonProperty("artist_name")
    public void setartist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    @JsonProperty("track_share_url")
    public String gettrack_share_url() {
        return track_share_url;
    }

    @JsonProperty("track_share_url")
    public void settrack_share_url(String track_share_url) {
        this.track_share_url = track_share_url;
    }

    @JsonProperty("track_edit_url")
    public String gettrack_edit_url() {
        return track_edit_url;
    }

    @JsonProperty("track_edit_url")
    public void settrack_edit_url(String track_edit_url) {
        this.track_edit_url = track_edit_url;
    }

    @JsonProperty("restricted")
    public Integer getRestricted() {
        return restricted;
    }

    @JsonProperty("restricted")
    public void setRestricted(Integer restricted) {
        this.restricted = restricted;
    }

    @JsonProperty("updated_time")
    public String getupdated_time() {
        return updated_time;
    }

    @JsonProperty("updated_time")
    public void setupdated_time(String updated_time) {
        this.updated_time = updated_time;
    }

    @JsonProperty("primary_genres")
    public PrimaryGenres getprimary_genres() {
        return primary_genres;
    }

    @JsonProperty("primary_genres")
    public void setprimary_genres(PrimaryGenres primary_genres) {
        this.primary_genres = primary_genres;
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
