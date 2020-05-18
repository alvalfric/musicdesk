<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>MusicDesk Search</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Oleo+Script:wght@700&display=swap')
	;

@import
	url('https://fonts.googleapis.com/css2?family=Leckerli+One&display=swap')
	;

body, html {
	height: 100%;
	width: 100%;
	margin: 0;
	padding: 0;
	background-image: url(/images/headphone.svg);
	background-size: cover;
}

.name {
	font-family: 'Leckerli One', cursive;
	font-size: 100px;
	-webkit-text-fill-color: #da4a54;
	-webkit-text-stroke-width: 4px;
	-webkit-text-stroke-color: black;
}

.searchbar {
	margin-bottom: auto;
	margin-top: auto;
	height: 50px;
	background-color: #1d3557;
	border-radius: 30px;
	padding: 10px;
}

.search_input {
	color: white;
	border: 0;
	outline: 0;
	background: none;
	width: 0;
	caret-color: transparent;
	line-height: 30px;
	transition: width 0.4s linear;
}

.searchbar>.search_input {
	padding: 0 10px;
	width: 400px;
	caret-color: red;
	transition: width 0.4s linear;
}

.searchbar:hover>.search_icon {
	color: #e74c3c;
}

.search_icon {
	background-color: #1d3557;
	border: none;
	height: 30px;
	width: 30px;
	float: right;
	display: flex;
	justify-content: center;
	align-items: center;
	border-radius: 50%;
	color: white;
	text-decoration: none;
	height: 30px;
}

#fixedbutton {
	position: fixed;
	bottom: 30px;
	right: 30px;
	font-size: 48px;
	color: #da4a54;
}

.fixedlogin {
	position: fixed;
	top: 4%;
	right: 4%;
}

.spotify {
	background-color: #1ed760;
	color: white;
}

.spotify {
	background-color: #4CAF50;
	color: white;
}

.spotify-short-text {
	display: none;
}

.btn {
	width: 280px;
	padding: 12px;
	border: none;
	border: none;
	border-radius: 4px;
	margin: 5px 0;
	opacity: 0.85;
	display: inline-block;
	font-size: 24px;
	line-height: 20px;
	text-decoration: none;
	border-radius: 4px;
	margin: 5px 0;
	opacity: 0.85;
	display: inline-block;
	font-size: 24px;
	line-height: 20px;
	text-decoration: none; /* remove underline from anchors */
}

.btn:hover {
	opacity: 1;
}

@media screen and (max-width: 960px) {
	.fixedlogin {
		position: fixed;
		top: 2%;
		right: 2%;
	}
	.btn {
		font-size: 20px;
		width: 120px;
	}
	.spotify-short-text {
		display: block;
	}
	.spotify-full-text {
		display: none;
	}
}
</style>
</head>
<body>
	<c:if
		test='${sessionScope["Spotify-token"] == null || sessionScope["Spotify-token"] == ""}'>
		<a href="" class="spotify fixedlogin btn"> <i
			class="fa fa-spotify fa-fw"></i> <span class="spotify-full-text">Require
				Spotify</span> <span class="spotify-short-text">Log in</span>
		</a>
	</c:if>
	<c:if
		test='${sessionScope["Spotify-token"] != null && sessionScope["Spotify-token"] != ""}'>
		<a href="#" class="spotify fixedlogin btn"> <i
			class="fa fa-spotify fa-fw"></i> <span class="spotify-full-text">Conectado
				a Spotify</span> <span class="spotify-short-text">Conectado</span>

		</a>
	</c:if>
	<a href="info.html"> <i id="fixedbutton" class="far fa-file-alt"></i></a>
	<div class="container h-50">
		<div class="d-flex justify-content-center">
			<img style="width: 30%; height: 30%;" src="cassette.png" />
		</div>
		<div class="d-flex justify-content-center"
			style="margin-top: -50; margin-bottom: -30;">
			<p class="name">MusicDesk</p>
			<br>
		</div>
		<br>
		<form id="searchForm" action="lyrics" method="post">
			<div class="d-flex justify-content-center">
				<div class="searchbar">
					<input class="search_input" type="text" name="searchQuery"
						placeholder="Buscar canción, artista, grupo..." required>
					<button class="search_icon">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</form>
		<br>
		<div class="d-flex justify-content-center">
			<a href="https://eventbook-aiss.ew.r.appspot.com/docs/"> <i class="fas fa-seedling" style="color:#da4a54;"></i> <span
				style="color: black;">Prueba nuestra API de eventos</span>
			</a>
		</div>
	</div>
	<a href="info.html"> <i id="fixedbutton" class="far fa-file-alt"></i></a>
</body>
</html>