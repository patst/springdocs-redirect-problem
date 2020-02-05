package de.patst.swaggerlogin.oauthmock;

import net.minidev.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdentityProviderController {

    @GetMapping(value = "/oauth/authorize",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String authorize(@RequestParam("client_id") String clientId,
                            @RequestParam("redirect_uri") String redirectUri,
                            @RequestParam("response_type") String type,
                            @RequestParam("state") String state) {
        JSONObject result =new JSONObject();
        result.put("client_id", clientId);
        result.put("redirect_uri", redirectUri);
        result.put("type", type);
        result.put("state", state);
        return result.toJSONString();
    }

}
