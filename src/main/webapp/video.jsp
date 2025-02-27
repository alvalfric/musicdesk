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

.container-iframe {
	position: relative;
	overflow: hidden;
	width: 100%;
	padding-top: 56.25%; /* 16:9 Aspect Ratio (divide 9 by 16 = 0.5625) */
}

.responsive-iframe {
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	width: 100%;
	height: 100%;
}
</style>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-9 col-md-6 col-lg-7"
				style="background-color: azure;">
				<br>
				<div class="container-iframe">
					<iframe class="responsive-iframe"
						src="https://www.youtube.com/embed/${youtubeSearch.getItems().get(0).getId().getVideoId()}"
						frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
				</div>
				<div class="container mt-3">
					<div class="media border p-2 bg-light">
						<div  style="background:#e63946;">
							<c:if
								test='${sessionScope["Youtube-token"] == null || sessionScope["Youtube-token"] == ""}'>
								<a href="/AuthController/Youtube" class="spotify fixedlogin btn">
									<i class="fa youtube fa-fw"></i><span style="color:white">Conectarse
										a Youtube</span>
								</a>
							</c:if>
						</div>
						<c:if
							test='${sessionScope["Youtube-token"] != null && sessionScope["Youtube-token"] != ""}'>

							<div class="media-body">

								<form id="searchForm" action="/youtubeCommentNew" method="post"
									class="form-inline my-2 my-lg-0">
									<textarea name="comment" placeholder="Comentario"
										style="height: 100px; width: 100%; box-sizing: border-box;"
										required></textarea>
									<input type="hidden" name="videoId"
										value="${requestScope.youtubeCommentThread.getItems().get(0).snippet.videoId}"
										required /> <input type="hidden" name="searchQuery" required
										value="${query}" /> <br>
									<button class="btn my-2 my-sm-0" type="submit" name="searchBtn"
										title="search" value="search"
										style="background-color: #e63946; color: white; margin-right: 2px;">Comentar</button>
								</form>
							</div>
						</c:if>
					</div>
				</div>
				<c:forEach items="${requestScope.youtubeCommentThread.getItems()}"
					var="comment">
					<div class="container mt-3">
						<div class="media border p-2 bg-light">
							<img
								src="${comment.snippet.topLevelComment.snippet.authorProfileImageUrl}"
								alt="Profile" class="mr-2 mt-2 rounded-circle"
								style="width: 60px;">
							<div class="media-body">
								<h4>
									<a
										href='<c:out value="${comment.snippet.topLevelComment.snippet.authorChannelUrl}"/>'
										style="color: black;"> <c:out
											value="${comment.snippet.topLevelComment.snippet.authorDisplayName}"></c:out>
									</a> <small><i>Publicado el <c:out
												value="${comment.snippet.topLevelComment.snippet.publishedAt}" /></i></small>
								</h4>
								<p>${comment.snippet.topLevelComment.snippet.textDisplay}</p>
							</div>
						</div>
					</div>
				</c:forEach>
				<br>
			</div>

			<div class="col-sm-3 col-md-6 col-lg-5 border">
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
							</fieldset>
						</c:if>
					</div>
				</div>
				</br>
			</div>
		</div>
	</div>
</body>
</html>