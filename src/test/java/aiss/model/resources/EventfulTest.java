package aiss.model.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

import aiss.model.eventful.Event;
import aiss.model.eventful.EventSearch;

public class EventfulTest {

	@Test
	public void getEventsTest() throws JsonParseException, JsonMappingException, IOException {
		String artist = "Dua Lipa";
		EventfulResource eventful = new EventfulResource();
		EventSearch eventResults = eventful.getEvents(artist);
		
		assertNotNull("The search returned null", eventResults);
		assertNotNull("The search returned null",eventResults.getEvents().getEvent());
		assertFalse("The number of events of " + artist + " is zero",eventResults.getEvents().getEvent().size()==0);
		
		System.out.println("The search for " + artist + "'s events returned " + eventResults.getEvents().getEvent().size() + " events.");
	
		for(Event e : eventResults.getEvents().getEvent()) {
			System.out.println("Event title "+e.getTitle()+ ", event date "+e.getstart_time());
		}
	}

	@Test
	public void getEventsErrorTest() throws JsonParseException, JsonMappingException, IOException {
		String artist = "Yung Beef";
		EventfulResource eventful = new EventfulResource();
		EventSearch eventResults = eventful.getEvents(artist);

		assertNull("The search returned null",eventResults.getEvents());		
	}

}
