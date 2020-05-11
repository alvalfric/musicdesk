package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.flickr.PhotoSearch;

public class FlickrTest {

	@Test
	public void getFlickrPhotosTest() throws UnsupportedEncodingException {
		String title = "Star Wars";
		FlickrResource flickr = new FlickrResource();
		PhotoSearch flickrResults = flickr.getFlickrPhotos(title);
		
		assertNotNull("The search returned null", flickrResults);
		assertNotNull("The search returned null", flickrResults.getPhotos());
		assertNotNull("The search returned null", flickrResults.getPhotos().getPhoto());
		assertFalse("The number of photos of " + title + " is zero", flickrResults.getPhotos().getPhoto().size()==0);
		
		System.out.println("The search for photos of " + title + " returned " + flickrResults.getPhotos().getPhoto().size() + " photos.");
	}

}
