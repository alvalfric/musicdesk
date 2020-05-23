package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeResource;

public class YoutubeCommentNewController extends HttpServlet {

	private static final long serialVersionUID = -6818025976353856770L;
	private static final Logger log = Logger.getLogger(YoutubeCommentNewController.class.getName());

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String comment = req.getParameter("comment");

		String query = req.getParameter("searchQuery");
		RequestDispatcher rd = null;

		req.setAttribute("query", query);
		
		if (comment != null && !comment.trim().isEmpty()) {

			String youtubeToken = (String) req.getSession().getAttribute("Youtube-token");
			if (youtubeToken != null && !"".equals(youtubeToken)) {
				YoutubeResource youtubeResource = new YoutubeResource(youtubeToken);

				youtubeResource.addComment(comment, req.getParameter("videoId"));

				req.setAttribute("comment", null);
				
				req.getRequestDispatcher("/video").forward(req, resp);
			} else {
				log.info("Trying to access Youtube without an access token, redirecting to OAuth servlet");
				req.getRequestDispatcher("/AuthController/Youtube").forward(req, resp);
			}
		} else {
			log.info("Controller invoked without parameters, redirecting to view");
			req.getRequestDispatcher("/video").forward(req, resp);
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
}
