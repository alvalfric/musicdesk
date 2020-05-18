package aiss.model.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.restlet.resource.ResourceException;

import aiss.model.musixmatch.lyrics.LyricSearch;
import aiss.model.musixmatch.track.SongSearch;
import aiss.model.musixmatch.track.TrackList;

public class MusixmatchTest {

	@Test
	public void getSongsTest() throws ResourceException, IOException {
		String tituloCancion = "Break my heart";
		String artistaCancion = "Dua Lipa";
		MusixmatchResources mxm = new MusixmatchResources();
		SongSearch searchSong = mxm.getSongs(tituloCancion, artistaCancion);

		assertNotNull("The search returned null", searchSong);
		assertNotNull("The search returned null", searchSong.getMessage().getBody().gettrack_list());
		assertFalse("The number of songs for " + artistaCancion + " - " + tituloCancion + " is zero",
				searchSong.getMessage().getBody().gettrack_list().size() == 0);

		System.out.println("The search for " + artistaCancion + " - " + tituloCancion + "'s songs returned "
				+ searchSong.getMessage().getBody().gettrack_list().size() + " songs.");
	}
	
	@Test
	public void getSongsNotFoundTest() throws ResourceException, IOException {
		String tituloCancion = "Bad song";
		String artistaCancion = "Bad Artist";
		MusixmatchResources mxm = new MusixmatchResources();
		SongSearch searchSong = mxm.getSongs(tituloCancion, artistaCancion);

		assertNotNull("The search returned null", searchSong);
		assertNotNull("The search returned null", searchSong.getMessage().getBody().gettrack_list());
		assertTrue("The number of songs for " + artistaCancion + " - " + tituloCancion + " is zero",
				searchSong.getMessage().getBody().gettrack_list().size() == 0);

		System.out.println("The search for " + artistaCancion + " - " + tituloCancion + "'s songs returned "
				+ searchSong.getMessage().getBody().gettrack_list().size() + " songs.");
	}

	@Test
	public void getLyricsTest() throws ResourceException, IOException {
		String tituloCancion = "Break my heart";
		String artistaCancion = "Dua Lipa";
		MusixmatchResources mxm = new MusixmatchResources();
		SongSearch searchSong = mxm.getSongs(tituloCancion, artistaCancion);

		assertNotNull("The search returned null", searchSong);
		assertNotNull("The search returned null", searchSong.getMessage().getBody().gettrack_list());
		assertFalse("The number of songs for " + artistaCancion + " - " + tituloCancion + " is zero",
				searchSong.getMessage().getBody().gettrack_list().size() == 0);

		int idSongLyrics = -1;
		for (TrackList tl : searchSong.getMessage().getBody().gettrack_list()) {
			if (tl.getTrack().gethas_lyrics().equals(1)) {
				idSongLyrics = tl.getTrack().gettrack_id();
			}
		}
		
		LyricSearch lyricSearch = new LyricSearch();
		lyricSearch = mxm.getLyrics(idSongLyrics);
		
		assertNotNull("The lyrics search returned null", lyricSearch);
		assertNotNull("The lyrics search returned null", lyricSearch.getMessage().getBody().getLyrics().getlyrics_body());
		
		System.out.println("Lyrics of"+ artistaCancion + " - " + tituloCancion + ": "+lyricSearch.getMessage().getBody().getLyrics().getlyrics_body());
	}
	
}
