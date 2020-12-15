package com.augy.example.democlient;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<OAuth2AuthenticationToken> hello(OAuth2AuthenticationToken currentUser) {
        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/user")
    public String user(Model model,
                       @AuthenticationPrincipal OidcUser oidcUser) {
        model.addAttribute("userName", oidcUser.getEmail());
        model.addAttribute("audience", oidcUser.getAudience());
        return "user";
    }
}
