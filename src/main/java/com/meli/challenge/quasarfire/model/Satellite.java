package com.meli.challenge.quasarfire.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Satellite {
    private String name;
    private Location location;
}
