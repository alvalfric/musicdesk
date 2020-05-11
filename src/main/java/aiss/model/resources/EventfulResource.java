package aiss.model.resources;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.resource.ClientResource;

import aiss.model.eventful.Event;
import aiss.model.eventful.EventSearch;

public class EventfulResource {

	private static final String EVENTFUL_API_KEY = "xRbMRFbXX3CC2sx2";

	private static final Logger log = Logger.getLogger(EventfulResource.class.getName());

	public EventSearch getEvents(String query) throws JsonParseException, JsonMappingException, IOException {

		String queryFormatted = URLEncoder.encode(query, "UTF-8");
		String uri = "http://api.eventful.com/json/events/search?q=" + queryFormatted + "&date=Future&app_key=" + EVENTFUL_API_KEY;
		log.log(Level.FINE, "Eventful URI: " + uri);

		ClientResource cr = new ClientResource(uri);
		ObjectMapper objectMapper = new ObjectMapper();
	
		System.out.println("eventfuluri"+uri);
		
		EventSearch eventSearch = objectMapper.readValue(cr.get(String.class), EventSearch.class);

		return eventSearch;
	}

}
