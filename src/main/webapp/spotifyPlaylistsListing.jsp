<%@include file="includes/header.jsp"%>
<h1>Spotify playlists</h1>

<div class="container">

    <p class="message">${message}</p>

    <table id="listas">
        <tr>
            <th>Name</th>				
        </tr>
        <c:forEach items="${playlists.items}" var="playlist">
            <tr>
                <td><c:out value="${playlist.name}"/></td>										
            </tr>
        </c:forEach>			
    </table>
    <p>
        <a href="/spotifyPlaylistNew" class="button">Create playlist in Spotify</a>
        <button type="button" onClick="javascript:window.location.href = '/'" class="button">Back</button>
</div>
<h1>Spotify Web Playback SDK Quick Start Tutorial</h1>
  <h2>Open your console log: <code>View > Developer > JavaScript Console</code></h2>

  <script src="https://sdk.scdn.co/spotify-player.js"></script>
  <script>
    window.onSpotifyWebPlaybackSDKReady = () => {
      const token = 'BQD_LuYIf3sAb4qQ0akDgjGHKlwQvJ6WbGtza30h4MPJM6F50V0cbbH8W5HqwkghVmOz0eW7BFJPPTJVYbn6fVeaYrgjKEj-8_AVUtRl9S6HkU9pqUDHfOwgC1tbgT_WGFvT9upMAYRI-R0IrOZ7pDBYatfw4M7LuQ';
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

<%@include file="includes/footer.jsp"%>
