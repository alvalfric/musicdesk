package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.auddio.AuddioSearch;
import aiss.model.eventful.EventSearch;
import aiss.model.flickr.PhotoSearch;
import aiss.model.gbooks.BookSearch;
import aiss.model.musixmatch.lyrics.LyricSearch;
import aiss.model.musixmatch.track.SongSearch;
import aiss.model.omdb.MovieSearch;
import aiss.model.resources.AuddioResource;
import aiss.model.resources.EventfulResource;
import aiss.model.resources.FlickrResource;
import aiss.model.resources.GBooksResource;
import aiss.model.resources.MusixmatchResources;
import aiss.model.resources.OMDbResource;
import aiss.model.resources.SpotifyResource;
import aiss.model.spotify.Playlists;

/**
 * Servlet implementation class SearchController
 */
public class SearchControllerOld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(SearchControllerOld.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchControllerOld() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;

		// Search for movies in OMDb
		log.log(Level.FINE, "Searching for OMDb movies that contain " + query);
		OMDbResource omdb = new OMDbResource();
		MovieSearch omdbResults = omdb.getMovies(query);

//		// Search for photos in Flickr
		log.log(Level.FINE, "Searching for Flickr photos with the tag " + query);
		FlickrResource flickr = new FlickrResource();
		PhotoSearch flickrResults = flickr.getFlickrPhotos("Dua Lipa"/* +query */);

		// Search for books in Google Books
		log.log(Level.FINE, "Searching for GBooks books whose title contain " + query);
		GBooksResource gbooks = new GBooksResource();
		BookSearch gbooksResults = gbooks.getBooks(query);

		// Search for movies in OMDb
		log.log(Level.FINE, "Searching for lyrics that contain " + query);
		MusixmatchResources mxm = new MusixmatchResources();
		SongSearch searchSong = mxm.getSongs(query,query);
		LyricSearch lyricSearch = new LyricSearch();
		if (searchSong.getMessage().getBody().gettrack_list().get(0).getTrack().gethas_lyrics().equals(1)) {
			lyricSearch = mxm
					.getLyrics(searchSong.getMessage().getBody().gettrack_list().get(0).getTrack().gettrack_id());
		}

//		// Search for books in Google Books
//		log.log(Level.FINE, "Searching for GBooks books whose title contain " + query);
//		AuddioResource auddio = new AuddioResource();
//		AuddioSearch auddioResults = auddio.getLyrics(query);

		// Search for events in Eventful
		log.log(Level.FINE, "Searching for events that contain " + query);
		EventfulResource eventful = new EventfulResource();
		EventSearch eventResults = eventful.getEvents(query);

		if (omdbResults != null && flickrResults != null /* && auddioResults!=null */) {
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("movies", omdbResults.getSearch());
			request.setAttribute("photos", flickrResults.getPhotos());
			request.setAttribute("books", gbooksResults.getItems());
			request.setAttribute("events", eventResults.getEvents().getEvent());
			/*
			 * request.setAttribute("auddioLyrics",
			 * auddioResults.getResult().get(0).getLyrics().replaceAll("\n", "</br>"));
			 */
			if (lyricSearch != null) {
				// String lyrics =
				// lyricSearch.getMessage().getBody().getLyrics().getlyrics_body();
				request.setAttribute("lyrics",
						lyricSearch.getMessage().getBody().getLyrics().getlyrics_body().replaceAll("\n", "</br>"));
			} else {
				request.setAttribute("lyrics", "Lyrics not found D:");
			}
			// request.setAttribute("lyrics", mxmLyrics);
		} else {
			log.log(Level.SEVERE, "OMDb object: " + omdbResults + ". Flickr object: " + flickrResults
					+ ". GBooks object: " + gbooksResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
