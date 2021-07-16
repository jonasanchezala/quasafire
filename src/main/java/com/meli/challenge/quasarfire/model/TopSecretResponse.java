package com.meli.challenge.quasarfire.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TopSecretResponse {
    private Location position;
    private String message;
}
