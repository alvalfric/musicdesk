<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.center {
	margin: auto;
	width: 80%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Search results</title>
</head>
<body>

	<div id="searchDiv">
		<form id="searchForm" action="SearchController" method="post">
			<input type="text" name="searchQuery" required /> <input
				type="submit" name="searchBtn" title="search" value="search">
		</form>
		<iframe
			src="https://open.spotify.com/embed/track/${searchSpotify.getTracks().getItems().get(0).getId()}"
			width="100%" height="80" frameborder="0" allowtransparency="true"
			allow="encrypted-media"></iframe>
	</div>

	<c:if
		test="${searchSpotify.getTracks().getItems().get(0).getPreviewUrl() != null}">
		<div class="center">
			<audio controls width="100%" name="media">
				<source
					src="<c:out value="${searchSpotify.getTracks().getItems().get(0).getPreviewUrl()}"/>"
					type="audio/mpeg">
			</audio>
		</div>
	</c:if>
	<div class="center">
		<iframe
			src="https://open.spotify.com/embed/track/${searchSpotify.getTracks().getItems().get(0).getId()}"
			width="300" height="380" frameborder="0" allowtransparency="true"
			allow="encrypted-media"></iframe>



	</div>
	<iframe
		src="https://open.spotify.com/embed/album/${searchSpotify.getTracks().getItems().get(0).getAlbum().getId()}"
		width="300" height="380" frameborder="0" allowtransparency="true"
		allow="encrypted-media"></iframe>

	<iframe
		src="https://open.spotify.com/embed/playlist/37i9dQZF1EpxpE8ch6kUWR"
		width="300" height="380" frameborder="0" allowtransparency="true"
		allow="encrypted-media"></iframe>
	<div class="center">
		<c:out
			value="${searchSpotify.getTracks().getItems().get(0).getExternalUrls().getSpotify()}" />
	</div>

	<img
		src='${searchSpotify.getTracks().getItems().get(0).getAlbum().getImages().get(0).getUrl()}' />

	<c:if test="${hasLyrics == true}">
		<fieldset id="lyrics">
			<legend>
				Lyrics search for
				<c:out value="${artistaCancion} - ${tituloCancion}" />
			</legend>
			${lyrics}
		</fieldset>
	</c:if>

	<c:if test="${hasEvents == true}">
		<fieldset id="events">
			<legend>
				Events search for
				<c:out value="${artistaCancion}" />
			</legend>
			<c:forEach items="${requestScope.events}" var="event">
				<c:out value="${event.city_name}" /> - <a href="${event.url}">More
					info</a>
				</br>
			</c:forEach>
		</fieldset>
	</c:if>

	<footer class="fixed_footer">
		<div class="content">
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
				Debitis ducimus nemo quo totam neque quis soluta nisi obcaecati
				aliquam saepe dicta adipisci blanditiis quaerat earum laboriosam
				accusamus nesciunt! Saepe ex maxime enim asperiores nisi. Obcaecati
				nostrum nobis laudantium aliquam commodi veniam magni similique
				ullam quis pariatur voluptatem harum id error.</p>
		</div>
	</footer>

</body>
</html>