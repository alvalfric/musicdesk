package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.spotify.Playlists;
import aiss.model.spotify.UserProfile;
import aiss.model.spotify.search.SearchSpotify;

public class SpotifyResource {

    private static final Logger log = Logger.getLogger(SpotifyResource.class.getName());

    private final String access_token;
    private final String baseURL = "https://api.spotify.com/v1";

    public SpotifyResource(String access_token) {
        this.access_token = access_token;
    }
    
    public SearchSpotify getTrack(String query) throws UnsupportedEncodingException {
        String trackGetURL = baseURL + "/search?q="+ URLEncoder.encode(query, "UTF-8") +"&type=track&market=ES&limit=1";
        ClientResource cr = new ClientResource(trackGetURL);
        
        ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);

        SearchSpotify searhSpority = null;
        
        try {
        	searhSpority = cr.get(SearchSpotify.class);
            return searhSpority;
        } catch (ResourceException re) {
            log.warning("Error when retrieving Spotify track: " + cr.getResponse().getStatus());
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
