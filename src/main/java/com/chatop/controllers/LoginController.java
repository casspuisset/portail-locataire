package com.chatop.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
// import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class LoginController {

    // private OAuth2AuthorizedClientService authorizedClientService;

    public LoginController(OAuth2AuthorizedClientService authorizedClientService) {
        // this.authorizedClientService = authorizedClientService;
    }

    @GetMapping("/user")
    public String getUser() {
        return "Welcome, User";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Welcome Admin";
    }

    @GetMapping("/")
    public String getUserInfo(Principal user) {
        StringBuffer userInfo = new StringBuffer();
        if (user instanceof UsernamePasswordAuthenticationToken) {
            userInfo.append(getUsernamePasswordLoginInfo(user));
        } else {
            userInfo.append(getOAuth2LoginInfo(user));
        }
        return userInfo.toString();
    }

    private StringBuffer getUsernamePasswordLoginInfo(Principal user) {
        StringBuffer usernameInfo = new StringBuffer();
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) user;
        if (token.isAuthenticated()) {
            User u = (User) token.getPrincipal();
            usernameInfo.append("Welcome, " + u.getUsername());
        } else {
            usernameInfo.append("NA");
        }
        return usernameInfo;
    }

    private StringBuffer getOAuth2LoginInfo(Principal user) {
        StringBuffer protectedInfo = new StringBuffer();
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) user;
        // OAuth2AuthorizedClient authClient = authorizedClientService.loadAuthorizedClient(
        //         token.getAuthorizedClientRegistrationId(), token.getName());
        if (token.isAuthenticated()) {
            Map<String, Object> userAttributes = ((DefaultOAuth2User) token.getPrincipal()).getAttributes();
            // String userToken = authClient.getAccessToken().getTokenValue();
            protectedInfo.append("Welcome, " + userAttributes.get("name") + "<br></br>");
            protectedInfo.append("e-mail : " + userAttributes.get("email") + "<br></br>");
        } else {
            protectedInfo.append("NA");
        }
        return protectedInfo;
    }
}
