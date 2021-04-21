package com.ducnt.foodie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Getter
public class JwtResponse {
    @NonNull
    private String token;

    @NonNull
    private UUID id;

    private String type = "Bearer";

    @NonNull
    private String email;

    @NonNull
    private List<String> roles;

    public JwtResponse(@NonNull String token, @NonNull UUID id, @NonNull String email, @NonNull List<String> roles) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.roles = roles;
    }
}
