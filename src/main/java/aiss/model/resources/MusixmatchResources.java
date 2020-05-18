package aiss.model.resources;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.musixmatch.lyrics.LyricSearch;
import aiss.model.musixmatch.track.SongSearch;

public class MusixmatchResources {

	private static final String MUSIXMATCH_API_KEY = "bcb4a344ffbfe6c214d5771e855e504c";

	private static final Logger log = Logger.getLogger(MusixmatchResources.class.getName());

	public SongSearch getSongs(final String titulo, final String artista) throws ResourceException, IOException {

		String uri = "https://api.musixmatch.com/ws/1.1/track.search?format=json&q_track="
				+ URLEncoder.encode(titulo, "UTF-8") + "&q_artist=" + URLEncoder.encode(artista, "UTF-8") + "&apikey="
				+ MusixmatchResources.MUSIXMATCH_API_KEY;

		MusixmatchResources.log.log(Level.FINE, "Musixmatch Track URI: " + uri);

		ClientResource cr = new ClientResource(uri);
		ObjectMapper objectMapper = new ObjectMapper();

		SongSearch searchSong = objectMapper.readValue(cr.get(String.class), SongSearch.class);

		return searchSong;
	}

	public LyricSearch getLyrics(final int songId) throws ResourceException, IOException {

		String uri = "https://api.musixmatch.com/ws/1.1/track.lyrics.get?track_id="
				+ URLEncoder.encode(String.valueOf(songId), "UTF-8") + "&apikey="
				+ MusixmatchResources.MUSIXMATCH_API_KEY;
		
		MusixmatchResources.log.log(Level.FINE, "Musixmatch Lyrics URI: " + uri);

		ClientResource cr = new ClientResource(uri);
		ObjectMapper objectMapper = new ObjectMapper();
		LyricSearch lyricSearch = objectMapper.readValue(cr.get(String.class), LyricSearch.class);

		return lyricSearch;
	}

}
