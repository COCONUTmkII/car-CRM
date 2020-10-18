package by.home.chevrolet.model;

import javax.validation.constraints.NotBlank;

public class RefreshTokenRequest {
    @NotBlank
    private String refreshToken;
    private String nickname;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
