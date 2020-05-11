
package aiss.model.youtube.commentthread.insert;

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
    "channelId",
    "videoId",
    "topLevelComment",
    "canReply",
    "totalReplyCount",
    "isPublic"
})
public class Snippet {

    @JsonProperty("channelId")
    private String channelId;
    @JsonProperty("videoId")
    private String videoId;
    @JsonProperty("topLevelComment")
    private TopLevelComment topLevelComment;
    @JsonProperty("canReply")
    private Boolean canReply;
    @JsonProperty("totalReplyCount")
    private Integer totalReplyCount;
    @JsonProperty("isPublic")
    private Boolean isPublic;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("channelId")
    public String getChannelId() {
        return channelId;
    }

    @JsonProperty("channelId")
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @JsonProperty("videoId")
    public String getVideoId() {
        return videoId;
    }

    @JsonProperty("videoId")
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @JsonProperty("topLevelComment")
    public TopLevelComment getTopLevelComment() {
        return topLevelComment;
    }

    @JsonProperty("topLevelComment")
    public void setTopLevelComment(TopLevelComment topLevelComment) {
        this.topLevelComment = topLevelComment;
    }

    @JsonProperty("canReply")
    public Boolean getCanReply() {
        return canReply;
    }

    @JsonProperty("canReply")
    public void setCanReply(Boolean canReply) {
        this.canReply = canReply;
    }

    @JsonProperty("totalReplyCount")
    public Integer getTotalReplyCount() {
        return totalReplyCount;
    }

    @JsonProperty("totalReplyCount")
    public void setTotalReplyCount(Integer totalReplyCount) {
        this.totalReplyCount = totalReplyCount;
    }

    @JsonProperty("isPublic")
    public Boolean getIsPublic() {
        return isPublic;
    }

    @JsonProperty("isPublic")
    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
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
