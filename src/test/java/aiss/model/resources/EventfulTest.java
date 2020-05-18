package aiss.model.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

import aiss.model.eventful.EventSearch;

public class EventfulTest {

	@Test
	public void getMoviesTest() throws JsonParseException, JsonMappingException, IOException {
		String artist = "Dua Lipa";
		EventfulResource eventful = new EventfulResource();
		EventSearch eventResults = eventful.getEvents(artist);
		
		assertNotNull("The search returned null", eventResults);
		assertNotNull("The search returned null",eventResults.getEvents().getEvent());
		assertFalse("The number of events of " + artist + " is zero",eventResults.getEvents().getEvent().size()==0);
		
		System.out.println("The search for " + artist + "'s events returned " + eventResults.getEvents().getEvent().size() + " events.");
		
		// Optional: Print movies data
	
	}

}
