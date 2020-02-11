package de.patst.swaggerlogin.oauthmock;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

@RestController
public class IdentityProviderController {

    @GetMapping(value = "/oauth/authorize")
    public ResponseEntity<Object> authorize(@RequestParam("client_id") String clientId,
                                            @RequestParam("redirect_uri") String redirectUri,
                                            @RequestParam("response_type") String type,
                                            @RequestParam("state") String state,
                                            HttpServletResponse response) throws IOException {
        return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, redirectUri+"?code=samplecode&state="+state).build();
    }

    @PostMapping(value = "/oauth/token", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @ResponseBody
    public OAuth2AccessToken token(@RequestParam("client_id") String clientId,
                                   @RequestParam("redirect_uri") String redirectUri,
                                   @RequestParam("grant_type") String type,
                                   @RequestParam("client_secret") String secret,
                                   @RequestParam("code") String code) {
        return new OAuth2AccessToken(OAuth2AccessToken.TokenType.BEARER,"mytoken", Instant.now(), Instant.now().plusMillis(1000000));
    }

}
