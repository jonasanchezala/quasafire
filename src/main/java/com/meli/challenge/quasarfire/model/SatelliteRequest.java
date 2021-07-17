package com.meli.challenge.quasarfire.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SatelliteRequest {
    private String name;
    private double distance;
    private List<String> message;
}
