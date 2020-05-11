package aiss.model.resources;

import aiss.model.spotify.NewPlaylist;
import aiss.model.spotify.Playlists;
import aiss.model.spotify.UserProfile;
import aiss.model.spotify.search.SearchSpority;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class SpotifyResource {

    private static final Logger log = Logger.getLogger(SpotifyResource.class.getName());

    private final String access_token;
    private final String baseURL = "https://api.spotify.com/v1";

    public SpotifyResource(String access_token) {
        this.access_token = access_token;
    }
    
    public SearchSpority getTrack(String query) throws UnsupportedEncodingException {
        String trackGetURL = baseURL + "/search?q="+ URLEncoder.encode(query, "UTF-8") +"&type=track&market=ES&limit=1";
        ClientResource cr = new ClientResource(trackGetURL);
        
        ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);

        System.out.println("tracksearch"+trackGetURL);
        SearchSpority searhSpority = null;
        try {
        	searhSpority = cr.get(SearchSpority.class);
            return searhSpority;

        } catch (ResourceException re) {
            log.warning("Error when retrieving Spotify playlists: " + cr.getResponse().getStatus());
            log.warning(trackGetURL);
            return null;
        }
    }
    
    public Playlists getPlaylists() {
        String playlistsGetURL = baseURL + "/me/playlists";
        ClientResource cr = new ClientResource(playlistsGetURL);

        ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);

        Playlists playlists = null;
        try {
            playlists = cr.get(Playlists.class);
            return playlists;

        } catch (ResourceException re) {
            log.warning("Error when retrieving Spotify playlists: " + cr.getResponse().getStatus());
            log.warning(playlistsGetURL);
            return null;
        }
    }

    public boolean createPlaylist(String name, String description) {
        String userId = this.getUserId();
        if (userId != null && !name.trim().isEmpty()) {
            String playlistPostURL = baseURL + "/users/" + userId + "/playlists";
            ClientResource cr = new ClientResource(playlistPostURL);

            ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
            chr.setRawValue(access_token);
            cr.setChallengeResponse(chr);

            NewPlaylist p = new NewPlaylist();
            p.setName(name);
            p.setDescription(description);

            log.info("Creating new playlist with name '" + name + "', description '" + description + "' and userId '" + userId + "'");

            try {
                cr.post(p, MediaType.APPLICATION_ALL_JSON);
                return true;

            } catch (ResourceException re) {
                log.warning("Error when creating a Spotify playlist: " + cr.getResponse().getStatus());
                log.warning(playlistPostURL);
                return false;
            }
        } else {
            log.warning("Error when getting userID from Spotify");
            return false;
        }
    }

    protected String getUserId() {
        String userProfileURL = baseURL + "/me";
        ClientResource cr = new ClientResource(userProfileURL);

        ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);

        log.info("Retrieving user profile");

        try {
            return cr.get(UserProfile.class).getId();

        } catch (ResourceException re) {
            log.warning("Error when retrieving the user profile: " + cr.getResponse().getStatus());
            log.warning(userProfileURL);
            return null;
        }
    }
}
