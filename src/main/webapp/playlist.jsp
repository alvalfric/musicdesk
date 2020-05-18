<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>MusicDesc Playlist</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Search results</title>
</head>
<style>
html, body {
	height: 100%;
	margin: 0;
}

.full-height {
	height: 100%;
	background: #2660A4;
}

.sticky {
	position: fixed;
	bottom: 0;
	width: 100%;
}
</style>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container-fluid" style="padding-bottom: 79px;">
		<div class="row">
			<div class="col-sm-9 col-md-6 col-lg-8">
				<br>
				<div class="row d-flex justify-content-center">
					<!-- 
					<img
						src='${searchSpotify.getTracks().getItems().get(0).getAlbum().getImages().get(1).getUrl()}' />
					</br>
					 -->
					<div class="col-11 d-flex bg-ligth justify-content-center">
						<c:if test="${hasLyrics == true}">
							<fieldset id="lyrics">
								<legend>
									Lyrics de
									<c:out value="${artistaCancion} - ${tituloCancion}" />
									<br> <br>
								</legend>
								${lyrics}
							</fieldset>
						</c:if>
						<c:if test="${hasLyrics != true}">
							<fieldset id="lyrics">
								<legend>
									No se han encontrado Lyrics para
									<c:out value="${artistaCancion} - ${tituloCancion}" />
									<br> <br>
								</legend>
								${lyrics}
							</fieldset>
						</c:if>
					</div>
				</div>
				</br>
			</div>
			<div class="col-sm-3 col-md-6 col-lg-4 border"
				style="background-color: azure;">
				<fieldset id="album">
					<legend> Album
						${searchSpotify.getTracks().getItems().get(0).getAlbum().getName()}
					</legend>
					<iframe id="album"
						src="https://open.spotify.com/embed/album/${searchSpotify.getTracks().getItems().get(0).getAlbum().getId()}"
						width="100%" height="380" frameborder="0" allowtransparency="true"
						allow="encrypted-media"></iframe>
				</fieldset>
				<fieldset id="playlist-fieldset">
					<legend> Mis Playlists </legend>
					<c:if test="${hasPlaylists == true}">
						<script type="text/javascript" src="changePlaylist.js"></script>
						<select id="playlist-select" style="width: 100%; height: 38px;">
							<c:forEach items="${playlists.items}" var="playlist">
								<option
									value="https://open.spotify.com/embed/playlist/${playlist.id}"><c:out
										value="${playlist.name}" /></option>
							</c:forEach>
						</select>
						</td>
						<iframe id="playlist"
							src="https://open.spotify.com/embed/playlist/${playlists.getItems().get(0).getId()}"
							width="100%" height="380" frameborder="0"
							allowtransparency="true" allow="encrypted-media"></iframe>
					</c:if>
					<c:if test="${hasPlaylists == false}">
						<p>No se ha encontrado ninguna playlist.</p>
					</c:if>
				</fieldset>
				<br>
			</div>
		</div>
	</div>

	<div class="sticky" style="margin-bottom: -6px;">
		<iframe
			src="https://open.spotify.com/embed/track/${searchSpotify.getTracks().getItems().get(0).getId()}"
			width="100%" height="80" frameborder="0" allowtransparency="true"
			allow="encrypted-media"></iframe>
	</div>
</body>
</html>