package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.repackaged.com.google.common.collect.BiMap;

import aiss.model.eventful.EventSearch;
import aiss.model.musixmatch.lyrics.LyricSearch;
import aiss.model.musixmatch.track.SongSearch;
import aiss.model.musixmatch.track.TrackList;
import aiss.model.resources.EventfulResource;
import aiss.model.resources.MusixmatchResources;
import aiss.model.resources.SpotifyResource;
import aiss.model.spotify.Playlists;
import aiss.model.spotify.search.SearchSpority;

/**
 * Servlet implementation class SearchController
 */
public class AlbumViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AlbumViewController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlbumViewController() {
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
				request.setAttribute("tituloCancion", tituloCancion);
				request.setAttribute("artistaCancion", artistaCancion);

				// Search for lyrics in MusixMatch
				log.log(Level.FINE, "Searching for lyrics that contain " + tituloCancion + " and " + artistaCancion);
				MusixmatchResources mxm = new MusixmatchResources();
				SongSearch searchSong = mxm.getSongs(tituloCancion, artistaCancion);
				LyricSearch lyricSearch = new LyricSearch();

				int idSongLyrics = -1;
				for (TrackList tl : searchSong.getMessage().getBody().gettrack_list()) {
					if (tl.getTrack().gethas_lyrics().equals(1)) {
						idSongLyrics = tl.getTrack().gettrack_id();
					}
				}

				if (idSongLyrics != -1) {
					lyricSearch = mxm.getLyrics(idSongLyrics);
					if (lyricSearch != null) {
						request.setAttribute("lyrics", lyricSearch.getMessage().getBody().getLyrics().getlyrics_body()
								.replaceAll("\n", "</br>"));
						request.setAttribute("hasLyrics", true);

					} else {
						request.setAttribute("lyrics", "Lyrics not found D:");
					}
				} else {
					System.out.println("entranolyrics");
					request.setAttribute("hasLyrics", false);

				}

				// Search for events in Eventful
				log.log(Level.FINE, "Searching for events that contain " + artistaCancion);
				EventfulResource eventful = new EventfulResource();
				EventSearch eventResults = eventful.getEvents(artistaCancion);
				if (!Integer.valueOf(eventResults.gettotal_items()).equals(0)) {
					request.setAttribute("hasEvents", true);
					request.setAttribute("events", eventResults.getEvents().getEvent());
				} else {
					request.setAttribute("hasEvents", false);
				}
////////////////////////////////////////////////////

				SpotifyResource asdf = new SpotifyResource(accessToken);
				Playlists playlists = asdf.getPlaylists();

				request.setAttribute("playlists", playlists);
				
				
				request.getRequestDispatcher("/lyrics.jsp").forward(request, response);

			} else {
				log.warning("No se ha encontrado la cancion");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		} else {
			log.info("Accediendo a Spotify sin autentificación");
			request.getRequestDispatcher("/AuthController/Spotify").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
