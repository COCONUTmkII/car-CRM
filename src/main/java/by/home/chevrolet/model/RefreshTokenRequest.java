package by.home.chevrolet.model;

import javax.validation.constraints.NotBlank;

public record RefreshTokenRequest(@NotBlank String refreshToken, String nickname) {

}
