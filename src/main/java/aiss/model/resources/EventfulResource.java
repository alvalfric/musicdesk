package aiss.model.resources;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.eventful.Event;
import aiss.model.eventful.EventSearch;
import aiss.model.spotify.search.SearchSpotify;

public class EventfulResource {

	private static final String EVENTFUL_API_KEY = "xRbMRFbXX3CC2sx2";

	private static final Logger log = Logger.getLogger(EventfulResource.class.getName());

	public EventSearch getEvents(String query) throws JsonParseException, JsonMappingException, IOException {

		String queryFormatted = URLEncoder.encode(query, "UTF-8");
		String uri = "http://api.eventful.com/json/events/search?q=" + queryFormatted + "&date=Future&app_key="
				+ EVENTFUL_API_KEY;
		log.log(Level.FINE, "Eventful URI: " + uri);

		ClientResource cr = new ClientResource(uri);
		ObjectMapper objectMapper = new ObjectMapper();

		EventSearch eventSearch = null;

		try {
			eventSearch = objectMapper.readValue(cr.get(String.class), EventSearch.class);
			return eventSearch;
		} catch (ResourceException re) {
			log.warning("Error when retrieving Eventful events: " + cr.getResponse().getStatus());
			log.warning(uri);
			return null;
		}
	}

}
