package by.home.chevrolet.model;

public record AuthenticationResponse(String authenticationToken, String nickname) {
    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public String getNickname() {
        return nickname;
    }
}
