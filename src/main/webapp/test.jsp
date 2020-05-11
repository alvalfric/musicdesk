<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.center {
  margin: auto;
  width: 60%;
  border: 3px solid #73AD21;
  padding: 10px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Search results</title>
</head>
<body>

	<div margin="auto" id="searchDiv">
		<form id="searchForm" action="SearchController" method="post">
			<input type="text" name="searchQuery" required /> <input
				type="submit" name="searchBtn" title="search" value="search">
		</form>
	</div>

	<c:if test="${searchSpotify.getTracks().getItems().get(0).getPreviewUrl() != null}">
		<video controls width="80%" height="40" name="media">
			<source src="<c:out value="${searchSpotify.getTracks().getItems().get(0).getPreviewUrl()}"/>" type="audio/mpeg">
		</video>
	</c:if>

	<img
		src='${searchSpotify.getTracks().getItems().get(0).getAlbum().getImages().get(0).getUrl()}' />


	<fieldset id="lyrics">
		<legend>
			Lyrics search for
			<c:out value="${param.searchQuery}" />
		</legend>
		${lyrics}
	</fieldset>

	<fieldset id="events">
		<legend>
			Events search for
			<c:out value="${param.searchQuery}" />
		</legend>
		<c:forEach items="${requestScope.events}" var="event">
			<c:out value="${event.city_name}" /> - <a href="${event.url}">More
				info</a>
			</br>
		</c:forEach>
	</fieldset>
	
  <h1>Spotify Web Playback SDK Quick Start Tutorial</h1>
  <h2>Open your console log: <code>View > Developer > JavaScript Console</code></h2>

  <script src="https://sdk.scdn.co/spotify-player.js"></script>
  <script>
    window.onSpotifyWebPlaybackSDKReady = () => {
      const token = '[My Spotify Web API access token]';
      const player = new Spotify.Player({
        name: 'Web Playback SDK Quick Start Player',
        getOAuthToken: cb => { cb(token); }
      });

      // Error handling
      player.addListener('initialization_error', ({ message }) => { console.error(message); });
      player.addListener('authentication_error', ({ message }) => { console.error(message); });
      player.addListener('account_error', ({ message }) => { console.error(message); });
      player.addListener('playback_error', ({ message }) => { console.error(message); });

      // Playback status updates
      player.addListener('player_state_changed', state => { console.log(state); });

      // Ready
      player.addListener('ready', ({ device_id }) => {
        console.log('Ready with Device ID', device_id);
      });

      // Not Ready
      player.addListener('not_ready', ({ device_id }) => {
        console.log('Device ID has gone offline', device_id);
      });

      // Connect to the player!
      player.connect();
    };
  </script>

</body>
</html>