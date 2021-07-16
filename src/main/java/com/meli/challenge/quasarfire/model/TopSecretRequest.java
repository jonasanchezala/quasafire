package com.meli.challenge.quasarfire.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TopSecretRequest {
    private List<SatelliteRequest> satellites;
}
