package aiss.model.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.spotify.Playlist;
import aiss.model.spotify.Playlists;
import aiss.model.spotify.search.Item;
import aiss.model.spotify.search.SearchSpotify;

public class SpotifyTest {

	private String accessToken = "BQCF68EhIr-Jf2ZTQjh1cBFEFCU5NuXnccfaRmodi57SCFd5ezCufHqQHe-X8Jjo1ZIj8FN-23AJ-qQqdav89rgrMfEeFFkiw6OzJSUiQ3_OTHiClKQFkxqgSFVB-0k4YptgxwCRDibN1XFot8jTk4ejJ4fprGX9CLo";

	@Test
	public void getTrackTest() throws UnsupportedEncodingException {
		String query = "break my heart";
		SpotifyResource spResource = new SpotifyResource(accessToken);
		SearchSpotify searchSpotify = spResource.getTrack(query);

		assertNotNull("The search returned null", searchSpotify);
		assertNotNull("The search returned null", searchSpotify.getTracks());
		assertFalse("The number of tracks of " + query + " is zero", searchSpotify.getTracks().getTotal() == 0);

		System.out.println("The search for " + query + "'s tracks returned "
				+ searchSpotify.getTracks().getItems().size() + " tracks.");

		// Print track data

		for (Item track : searchSpotify.getTracks().getItems()) {
			System.out.println("Track name: " + track.getName() + ", Artists: " + track.getArtists().get(0).getName());
		}
	}

	@Test
	public void getTrackByArtistTest() throws UnsupportedEncodingException {
		String query = "system of a down";
		SpotifyResource spResource = new SpotifyResource(accessToken);
		SearchSpotify searchSpotify = spResource.getTrack(query);

		assertNotNull("The search returned null", searchSpotify);
		assertNotNull("The search returned null", searchSpotify.getTracks());
		assertFalse("The number of tracks of " + query + " is zero", searchSpotify.getTracks().getTotal() == 0);

		System.out.println("The search for " + query + "'s tracks returned "
				+ searchSpotify.getTracks().getItems().size() + " tracks.");

		// Print track data

		for (Item track : searchSpotify.getTracks().getItems()) {
			System.out.println("Track name: " + track.getName() + ", Artists: " + track.getArtists().get(0).getName());
		}
	}

	@Test
	public void getTrackNotFoundTest() throws UnsupportedEncodingException {
		String query = "this song wont be found";
		SpotifyResource spResource = new SpotifyResource(accessToken);
		SearchSpotify searchSpotify = spResource.getTrack(query);

		assertTrue("The number of tracks of " + query + " is zero", searchSpotify.getTracks().getTotal() == 0);
	}

	@Test
	public void getTrackErrorTest() throws UnsupportedEncodingException {
		String query = "cancion que no se va a encontrar";
		SpotifyResource spResource = new SpotifyResource("badtoken");
		SearchSpotify searchSpotify = spResource.getTrack(query);

		assertNull("The track search returned null due to wrong token", searchSpotify);
	}

	@Test
	public void getUserIdTest() throws UnsupportedEncodingException {
		SpotifyResource spResource = new SpotifyResource(accessToken);
		String userId = spResource.getUserId();

		assertNotNull("The search returned null", userId);

		System.out.println("The user id is " + userId);
	}

	@Test
	public void getUserIdErrorTest() throws UnsupportedEncodingException {
		SpotifyResource spResource = new SpotifyResource("badtoken");
		String userId = spResource.getUserId();

		assertNull("The search returned null due to wrong token", userId);

		System.out.println("The user id is " + userId);
	}

	@Test
	public void getPlaylistTest() throws UnsupportedEncodingException {
		SpotifyResource spResource = new SpotifyResource(accessToken);
		Playlists playlist = spResource.getPlaylists();

		assertNotNull("The search returned null", playlist);
		assertNotNull("The search returned null", playlist.getItems());
		assertFalse("The number of playlist is zero", playlist.getItems().size() == 0);

		System.out.println(
				"The number of playlist for the user " + spResource.getUserId() + " is " + playlist.getItems().size());

		// Print playlists data
		for (Playlist p : playlist.getItems()) {
			System.out.println("Playlist name: " + p.getName() + ", Number of tracks: " + p.getTracks().getTotal());
		}
	}

	@Test
	public void getPlaylistErrorTest() throws UnsupportedEncodingException {
		SpotifyResource spResource = new SpotifyResource("badtoken");
		Playlists playlist = spResource.getPlaylists();

		assertNull("The search returned null due to wrong token", playlist);
	}
}
