
package aiss.model.auddio;

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
    "song_id",
    "artist_id",
    "title",
    "title_with_featured",
    "full_title",
    "artist",
    "lyrics",
    "media"
})
public class Result {

    @JsonProperty("song_id")
    private String songId;
    @JsonProperty("artist_id")
    private String artistId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("title_with_featured")
    private String titleWithFeatured;
    @JsonProperty("full_title")
    private String fullTitle;
    @JsonProperty("artist")
    private String artist;
    @JsonProperty("lyrics")
    private String lyrics;
    @JsonProperty("media")
    private String media;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("song_id")
    public String getSongId() {
        return songId;
    }

    @JsonProperty("song_id")
    public void setSongId(String songId) {
        this.songId = songId;
    }

    @JsonProperty("artist_id")
    public String getArtistId() {
        return artistId;
    }

    @JsonProperty("artist_id")
    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("title_with_featured")
    public String getTitleWithFeatured() {
        return titleWithFeatured;
    }

    @JsonProperty("title_with_featured")
    public void setTitleWithFeatured(String titleWithFeatured) {
        this.titleWithFeatured = titleWithFeatured;
    }

    @JsonProperty("full_title")
    public String getFullTitle() {
        return fullTitle;
    }

    @JsonProperty("full_title")
    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    @JsonProperty("artist")
    public String getArtist() {
        return artist;
    }

    @JsonProperty("artist")
    public void setArtist(String artist) {
        this.artist = artist;
    }

    @JsonProperty("lyrics")
    public String getLyrics() {
        return lyrics;
    }

    @JsonProperty("lyrics")
    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    @JsonProperty("media")
    public String getMedia() {
        return media;
    }

    @JsonProperty("media")
    public void setMedia(String media) {
        this.media = media;
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
