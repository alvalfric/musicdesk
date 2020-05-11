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
import aiss.model.spotify.search.SearchSpority;

/**
 * Servlet implementation class SearchController
 */
public class SearchControllerAntesDeCambios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SearchControllerAntesDeCambios.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchControllerAntesDeCambios() {
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

		String accessToken = (String) request.getSession().getAttribute("Spotify-token");

		if (accessToken != null && !"".equals(accessToken)) {
			SpotifyResource spResource = new SpotifyResource(accessToken);
			SearchSpority searchSpotify = spResource.getTrack(query);
			
			if (searchSpotify != null && searchSpotify.getTracks() != null
					&& searchSpotify.getTracks().getItems().size() > 0
					&& searchSpotify.getTracks().getItems().get(0) != null) {
				
				request.setAttribute("searchSpotify", searchSpotify);

				String tituloCancion = searchSpotify.getTracks().getItems().get(0).getName();
				String artistaCancion = searchSpotify.getTracks().getItems().get(0).getArtists().get(0).getName();
				String previewUrlCancion = searchSpotify.getTracks().getItems().get(0).getPreviewUrl();

				request.setAttribute("previewUrlCancion", previewUrlCancion);
				
				// Search for movies in OMDb
				log.log(Level.FINE, "Searching for OMDb movies that contain " + query);
				OMDbResource omdb = new OMDbResource();
				MovieSearch omdbResults = omdb.getMovies(query);

				// Search for photos in Flickr
				log.log(Level.FINE, "Searching for Flickr photos with the tag " + query);
				FlickrResource flickr = new FlickrResource();
				PhotoSearch flickrResults = flickr.getFlickrPhotos(artistaCancion);

				// Search for books in Google Books
				log.log(Level.FINE, "Searching for GBooks books whose title contain " + query);
				GBooksResource gbooks = new GBooksResource();
				BookSearch gbooksResults = gbooks.getBooks(query);

//				// Auddio
//				log.log(Level.FINE, "Searching for GBooks books whose title contain " + query);
//				AuddioResource auddio = new AuddioResource();
//				AuddioSearch auddioResults = auddio.getLyrics(query);			

				// Search for lyrics in MusixMatch
				log.log(Level.FINE, "Searching for lyrics that contain " + tituloCancion + " and " + artistaCancion);
				MusixmatchResources mxm = new MusixmatchResources();
				SongSearch searchSong = mxm.getSongs(tituloCancion, artistaCancion);
				LyricSearch lyricSearch = new LyricSearch();
				if (searchSong.getMessage().getBody().gettrack_list().get(0).getTrack().gethas_lyrics().equals(1)) {
					lyricSearch = mxm.getLyrics(
							searchSong.getMessage().getBody().gettrack_list().get(0).getTrack().gettrack_id());
				}

				// Search for events in Eventful
				log.log(Level.FINE, "Searching for events that contain " + artistaCancion);
				EventfulResource eventful = new EventfulResource();
				EventSearch eventResults = eventful.getEvents(artistaCancion);

				if (omdbResults != null && flickrResults != null /* && auddioResults!=null */) {
					rd = request.getRequestDispatcher("/test.jsp");
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
						request.setAttribute("lyrics", lyricSearch.getMessage().getBody().getLyrics().getlyrics_body()
								.replaceAll("\n", "</br>"));
					} else {
						request.setAttribute("lyrics", "Lyrics not found D:");
					}
					// request.setAttribute("lyrics", mxmLyrics);
				} else {
					log.log(Level.SEVERE, "OMDb object: " + omdbResults + ". Flickr object: " + flickrResults
							+ ". GBooks object: " + gbooksResults);
					rd = request.getRequestDispatcher("/error.jsp");
				}
//				rd.forward(request, response);

				request.getRequestDispatcher("/test.jsp").forward(request, response);
			} else {
				log.warning("No se ha encontrado la cancion");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		} else {
			log.info("Trying to access Spotify without an access token, redirecting to OAuth servlet");
			request.getRequestDispatcher("/AuthController/Spotify").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
