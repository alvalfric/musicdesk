<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>MusicDesc Lyrics</title>
<link rel="icon" type="image/png" href="cassette.png"
	sizes="32x32" />
<link rel="icon" type="image/png" href="cassette.png"
	sizes="16x16" />
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
	height: 97%;
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
			<c:if test="${hasEvents == true}">
				<div class="col-sm-3 col-md-6 col-lg-4 border"
					style="background-color: azure;">
					<fieldset id="events">
						<legend>
							Eventos de
							<c:out value="${artistaCancion}" />
						</legend>
						<c:forEach items="${requestScope.events}" var="event">
							<div class="container mt-3">
								<div class="media border p-1" style="background-color: white">
									<c:if test="${event.image.medium.url!=null}">
										<img src="${event.image.medium.url}" alt="Not Found D:"
											class="mr-3 mt-2" style="width: 60px;">
									</c:if>
									<c:if test="${event.image.medium.url==null}">
										<img
											src="${searchSpotify.getTracks().getItems().get(0).getAlbum().getImages().get(0).getUrl()}"
											alt="Not Found D:" class="mr-3 mt-2" style="width: 60px;">
									</c:if>
									<div class="media-body">
										<h4>
											<c:out value="${event.country_name}," />
											<c:out value="${event.city_name}" />
											<small><i> <c:out
														value="${event.getDateInSpanish()}" />
											</i></small>
										</h4>
										<a href="${event.url}">Más información</a> </br>
									</div>
								</div>
							</div>
						</c:forEach>
					</fieldset>
					<br>
				</div>
			</c:if>
			<c:if test="${hasEvents != true}">
				<div class="col-sm-3 col-md-6 col-lg-4 border"
					style="background-color: azure;">
					<fieldset id="events">
						<legend>
							No se han encontrado eventos para
							<c:out value="${artistaCancion}" />
						</legend>
					</fieldset>
					<br>
				</div>
			</c:if>
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