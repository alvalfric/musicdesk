package aiss.model.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.youtube.commentthread.list.YoutubeCommentThread;
import aiss.model.youtube.search.Item;
import aiss.model.youtube.search.YoutubeSearch;

public class YoutubeTest {

	private String accessToken = "ya29.a0AfH6SMBz2WU6qgqCxxzjzyFTXQFXzVLvH81xHbLl3MtChH0br-vxpgWbsHVEnAUv8gVvYvXS73RVVV-jvNqtxmtaNS33_5xNjwmcmAv532yjN4E5MegTtxW_FCmLhwtYRn8xIz9LiEvrsot8tVA1nez-3TW9dfDUjQs";

	@Test
	public void getSearchTest() throws UnsupportedEncodingException {
		String query = "Redbone - Come and Get Your Love";
		YoutubeResource youtubeSearch = new YoutubeResource(accessToken);
		YoutubeSearch youtubeSearchResults = youtubeSearch.getSearch(query);

		assertNotNull("The search returned null", youtubeSearchResults);
		assertNotNull("The search returned null", youtubeSearchResults.getItems());
		assertFalse("The number of searched videos of " + query + " is zero",
				youtubeSearchResults.getItems().size() == 0);

		System.out.println("The searched videos for " + query + " returned " + youtubeSearchResults.getItems().size()
				+ " matches.");

		// Optional: Print search data

		for (Item ys : youtubeSearchResults.getItems()) {
			System.out.println("Id for video " + ys.getSnippet().getTitle() + ": " + ys.getId());
		}
	}

	@Test
	public void getSearchNotFoundTest() throws UnsupportedEncodingException {
		String query = "thisisavideothatwontbefoundandwillreturnanerror";
		YoutubeResource youtubeSearch = new YoutubeResource(accessToken);
		YoutubeSearch youtubeSearchResults = youtubeSearch.getSearch(query);

		assertTrue("The search returned null", youtubeSearchResults.getItems().isEmpty());
		assertTrue("The number of searched videos of " + query + " is zero",
				youtubeSearchResults.getItems().size() == 0);
	}

	@Test
	public void getSearchBadAccessTokenTest() throws UnsupportedEncodingException {
		String query = "Redbone - Come and Get Your Love";
		YoutubeResource youtubeSearch = new YoutubeResource("badToken");
		YoutubeSearch youtubeSearchResults = youtubeSearch.getSearch(query);

		assertNotNull("The search returned null", youtubeSearchResults.getItems());
		assertFalse("The number of searched videos of " + query + " is zero",
				youtubeSearchResults.getItems().size() == 0);
	}

	@Test
	public void getCommetsTest() throws UnsupportedEncodingException {
		YoutubeResource youtubeSearch = new YoutubeResource(accessToken);
		YoutubeCommentThread youtubeCommentThreadResults = youtubeSearch.getCommets("bc0KhhjJP98");

		assertNotNull("The search returned null", youtubeCommentThreadResults);
		assertNotNull("The search returned null", youtubeCommentThreadResults.getItems());
		assertFalse("The number of comments found is zero", youtubeCommentThreadResults.getItems().size() == 0);

		System.out.println(
				"The searched video comments returned " + youtubeCommentThreadResults.getItems().size() + " matches.");
	}
	
	@Test
	public void getCommetsBadAccessTokenTest() throws UnsupportedEncodingException {
		YoutubeResource youtubeSearch = new YoutubeResource("badToken");
		YoutubeCommentThread youtubeCommentThreadResults = youtubeSearch.getCommets("bc0KhhjJP98");

		assertNotNull("The search returned null", youtubeCommentThreadResults.getItems());
		assertFalse("The number of comments found is zero", youtubeCommentThreadResults.getItems().size() == 0);
	}

	@Test
	public void getChannelIdTest() throws UnsupportedEncodingException {
		YoutubeResource youtubeSearch = new YoutubeResource(accessToken);
		String channelId = youtubeSearch.getChannelId();

		assertNotNull("The search returned null", channelId);
		assertFalse("The search returned empty", channelId.isEmpty());
	}
	
	@Test
	public void addCommentTest() throws UnsupportedEncodingException {
		String comment="I love this song!";
		String videoId="bc0KhhjJP98";
		YoutubeResource youtubeResource = new YoutubeResource(accessToken);
		
		assertTrue("Comment was successfully posted", youtubeResource.addComment(comment, videoId));
	}
	
	@Test
	public void addCommentBadVideoIdTest() throws UnsupportedEncodingException {
		String comment="I love this song!";
		String videoId="badVideoId";
		YoutubeResource youtubeResource = new YoutubeResource(accessToken);
		
		assertFalse("Comment was successfully posted", youtubeResource.addComment(comment, videoId));
	}
}
