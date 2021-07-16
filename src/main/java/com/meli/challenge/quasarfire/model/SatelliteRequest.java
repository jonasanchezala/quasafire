package com.meli.challenge.quasarfire.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SatelliteRequest {
    private String name;
    private double distance;
    private List<String> message;
}
