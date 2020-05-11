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
import aiss.model.resources.YoutubeResource;
import aiss.model.spotify.Playlists;
import aiss.model.spotify.search.SearchSpority;
import aiss.model.youtube.commentthread.list.YoutubeCommentThread;
import aiss.model.youtube.search.YoutubeSearch;

/**
 * Servlet implementation class SearchController
 */
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(VideoController.class.getName());
	private static String query = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("searchQuery") != null && !request.getParameter("searchQuery").isEmpty()) {
			query = request.getParameter("searchQuery");
		}
		
		RequestDispatcher rd = null;

		request.setAttribute("query", query);
		System.out.println("queryxd" + query);
		String accessToken = (String) request.getSession().getAttribute("Spotify-token");

		if (accessToken != null && !"".equals(accessToken)) {
			String youtubeToken = (String) request.getSession().getAttribute("Youtube-token");

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

				SpotifyResource asdf = new SpotifyResource(accessToken);
				Playlists playlists = asdf.getPlaylists();

				request.setAttribute("playlists", playlists);

				YoutubeResource youtubeSearch = new YoutubeResource(youtubeToken);
				YoutubeSearch youtubeSearchResults = youtubeSearch.getSearch(artistaCancion + " " + tituloCancion);
				request.setAttribute("youtubeSearch", youtubeSearchResults);

				YoutubeCommentThread youtubeCommentThreadResults = youtubeSearch
						.getCommets(youtubeSearchResults.getItems().get(0).getId().getVideoId());
				request.setAttribute("youtubeCommentThread", youtubeCommentThreadResults);

				request.getRequestDispatcher("/video.jsp").forward(request, response);

			} else {
				log.warning("No se ha encontrado la cancion");
				request.getSession().setAttribute("Spotify-token", "");
				request.getSession().setAttribute("Youtube-token", "");
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
