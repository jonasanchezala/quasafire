package com.meli.challenge.quasarfire.model;

import java.util.List;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TopSecretRequest {
    private List<SatelliteRequest> satellites;
}
