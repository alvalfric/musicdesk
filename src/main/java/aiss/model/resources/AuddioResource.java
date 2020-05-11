package aiss.model.resources;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.auddio.AuddioSearch;

public class AuddioResource {

	private static final String AUDDIO_API_KEY = "1d92db797145bc45d626ed6c7bc030f7";

	private static final Logger log = Logger.getLogger(AuddioResource.class.getName());

	public AuddioSearch getLyrics(final String query) throws ResourceException, IOException {

		String queryFormatted = URLEncoder.encode(query+ "+dua+lipa", "UTF-8");

		String uri = "https://api.audd.io/findLyrics/?q="+queryFormatted+"&api_token="+AUDDIO_API_KEY;

		AuddioResource.log.log(Level.FINE, "Auddio Lyrics URI: " + uri);

		ClientResource cr = new ClientResource(uri);
//		ObjectMapper objectMapper = new ObjectMapper();
//		AuddIOSearch searchSong = objectMapper.readValue(cr.get(String.class), AuddIOSearch.class);
		AuddioSearch auddioSearch = cr.get(AuddioSearch.class);
		//System.out.println(cr.get(MediaType.APPLICATION_JSON));

		return auddioSearch;
	}

}
