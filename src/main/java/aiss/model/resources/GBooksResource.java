package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;

import aiss.model.gbooks.BookSearch;

public class GBooksResource {
	
	private static final String GBOOK_API_KEY = "AIzaSyAiLu_FYM2s_TKKe_pjNSZimDMvkw0yRO8";
	private static final Logger log = Logger.getLogger(GBooksResource.class.getName());
	
	public BookSearch getBooks(String query) throws UnsupportedEncodingException {
		
		String uri = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + URLEncoder.encode(query, "UTF-8") + 
				        "&country=es&key=" + GBOOK_API_KEY;
		
		log.log(Level.FINE, "Google Books URI: " + uri);
		
		ClientResource cr = new ClientResource(uri);
	    BookSearch gbooksSearch = cr.get(BookSearch.class);

	    return gbooksSearch;
	}

}
