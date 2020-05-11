package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.spotify.UserProfile;
import aiss.model.youtube.commentthread.insert.CommentThread;
import aiss.model.youtube.commentthread.insert.Snippet;
import aiss.model.youtube.commentthread.insert.Snippet_;
import aiss.model.youtube.commentthread.insert.TopLevelComment;
import aiss.model.youtube.commentthread.list.YoutubeCommentThread;
import aiss.model.youtube.search.YoutubeSearch;
import aiss.model.youtube.user.YoutubeUser;

public class YoutubeResource {

	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());
	private static final String YOUTUBE_API_KEY = "AIzaSyADlZ20jxUpetQ8yJzGZW5InFmVqtHIqXc";

	private final String access_token;
	private final String baseURL = "https://www.googleapis.com/youtube/v3/";

	public YoutubeResource(String access_token) {
		this.access_token = access_token;
	}

	public YoutubeSearch getSearch(String query) throws UnsupportedEncodingException {
		String uri = baseURL + "search?part=snippet&q=" + URLEncoder.encode(query, "UTF-8") + "&type=video&key="
				+ YOUTUBE_API_KEY;

		YoutubeResource.log.log(Level.FINE, "Youtube Video URI: " + uri);

		ClientResource cr = new ClientResource(uri);
		YoutubeSearch youtubeSearch = cr.get(YoutubeSearch.class);

		try {
			youtubeSearch = cr.get(YoutubeSearch.class);
			return youtubeSearch;

		} catch (ResourceException re) {
			log.warning("Error when retrieving Youtube search: " + cr.getResponse().getStatus());
			log.warning(uri);
			return null;
		}
	}

	public YoutubeCommentThread getCommets(String videoId) throws UnsupportedEncodingException {
		//add order=relevance to order by popularity
		String uri = baseURL + "commentThreads?part=snippet&maxResults=10&videoId="
				+ URLEncoder.encode(videoId, "UTF-8") + "&key=" + YOUTUBE_API_KEY;

		YoutubeResource.log.log(Level.FINE, "Youtube Comments URI: " + uri);

		ClientResource cr = new ClientResource(uri);
		YoutubeCommentThread commentThread = cr.get(YoutubeCommentThread.class);

		try {
			commentThread = cr.get(YoutubeCommentThread.class);
			return commentThread;

		} catch (ResourceException re) {
			log.warning("Error when retrieving Youtube Comment search: " + cr.getResponse().getStatus());
			log.warning(uri);
			return null;
		}
	}

	public boolean addComment(String comment, /* String channelId, */ String videoId)
			throws UnsupportedEncodingException {

		String channelId = this.getChannelId();
		if (channelId != null && !comment.trim().isEmpty() && !videoId.isEmpty() && videoId != null) {
			String commentPostUrl = baseURL + "commentThreads?part=snippet&maxResults=10&order=relevance&videoId="
					+ URLEncoder.encode(videoId, "UTF-8") + "&key=" + YOUTUBE_API_KEY;
			
			ClientResource cr = new ClientResource(commentPostUrl);
			ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);

			chr.setRawValue(access_token);
			cr.setChallengeResponse(chr);

			CommentThread ct = new CommentThread();
			// ct.getSnippet().setChannelId("");
			Snippet snippet = new Snippet();
			TopLevelComment tlc = new TopLevelComment();
			Snippet_ snippet_ = new Snippet_();

			ct.setKind("youtube#commentThread");
			snippet.setTopLevelComment(tlc);
			tlc.setSnippet(snippet_);

			ct.setSnippet(snippet);
			ct.getSnippet().getTopLevelComment().getSnippet().setTextOriginal(comment);
			ct.getSnippet().setVideoId(videoId);
			ct.getSnippet().setChannelId(channelId);

			// log.info("Creating new comment with description '" + comment + "' and userId
			// '" + userId + "'");

			try {
				cr.post(ct, MediaType.APPLICATION_ALL_JSON);
				return true;

			} catch (ResourceException re) {
				log.warning("Error when posting a Youtube comment: " + cr.getResponse().getStatus());
				log.warning(commentPostUrl);
				return false;
			}
		} else {
			log.warning("Error when getting userID from Spotify");
			return false;
		}
	}

	protected String getChannelId() {
		String userProfileURL = "https://www.googleapis.com/youtube/v3/channels?part=id&mine=true&access_token="
				+ access_token;

		ClientResource cr = new ClientResource(userProfileURL);

		log.info("Retrieving user channel id");
		try {
			return cr.get(YoutubeUser.class).getItems().get(0).getId();

		} catch (ResourceException re) {
			log.warning("Error when retrieving the user profile: " + cr.getResponse().getStatus());
			log.warning(userProfileURL);
			return null;
		}
	}
}
