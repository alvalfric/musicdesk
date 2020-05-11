package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;

import aiss.controller.SearchController;
import aiss.model.flickr.PhotoSearch;

public class FlickrResource {

	private static final String FLICKR_API_KEY = "7094e05fa07e935b81972724619789a0";		// TODO: Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(FlickrResource.class.getName());

	
	public PhotoSearch getFlickrPhotos(String artist) throws UnsupportedEncodingException{
		
		String uri = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=" + 
					   FLICKR_API_KEY + "&tags=" + URLEncoder.encode(artist, "UTF-8") + "&format=json&per_page=20&nojsoncallback=1"; 
		
		log.log(Level.FINE, "Flickr URI: " + uri);
		
		ClientResource cr = new ClientResource(uri);
		PhotoSearch flickrSearch = cr.get(PhotoSearch.class);
		
		return flickrSearch;
	}
	
}
