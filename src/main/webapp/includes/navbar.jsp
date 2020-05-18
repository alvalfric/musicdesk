<nav class="navbar navbar-expand-lg navbar-dark sticky-top"
	style="background: #1d3557">
	<a class="navbar-brand" href="index.jsp"><img src="cassette.png"
		style="width: 40px;" /></a>
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navb">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navb">
		<ul class="navbar-nav mr-auto">
			<form id="lyricsForm" action="lyrics" method="post">
				<input type="hidden" name="searchQuery" required value="${query}" />
				<li class="nav-item" onclick="lyricsForm.submit();"><a
					class="nav-link" href="javascript:void(0)">Lyrics</a></li>
			</form>
			<form id="playlistForm" action="playlist" method="post">
				<input type="hidden" name="searchQuery" required value="${query}" />
				<li class="nav-item" onclick="playlistForm.submit();"><a
					class="nav-link" href="javascript:void(0)">Playlist</a></li>
			</form>

			<form id="videoForm" action="video" method="post">
				<input type="hidden" name="searchQuery" required value="${query}" />
				<li class="nav-item" onclick="videoForm.submit();"><a
					class="nav-link" href="javascript:void(0)">Video</a></li>
			</form>
		</ul>
		<form id="searchForm" action="lyrics" method="post"
			class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="text" name="searchQuery"
				placeholder="Buscar canción, artista..." required />
			<button class="btn my-2 my-sm-0" type="submit" name="searchBtn"
				title="search" value="search"
				style="background-color: #e63946; color: white;">Buscar</button>
		</form>
	</div>
</nav>