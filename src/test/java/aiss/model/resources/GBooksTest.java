package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.gbooks.BookSearch;

public class GBooksTest {

	@Test
	public void getBooksTest() throws UnsupportedEncodingException {
		String title = "Star Wars";
		GBooksResource gbooks = new GBooksResource();
		BookSearch gbooksSearch = gbooks.getBooks(title);
		
		assertNotNull("The search returned null", gbooksSearch);
		assertNotNull("The search returned null", gbooksSearch.getItems());
		assertFalse("The number of matches for " + title + " is zero", gbooksSearch.getItems().size()==0);
		
		System.out.println("The search for " + title + " returned " + gbooksSearch.getItems().size() + " artists.");

	
	}

}
