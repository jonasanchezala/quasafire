package com.meli.challenge.quasarfire.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TopSecretRequest {
    private List<SatelliteRequest> satellites;
}
