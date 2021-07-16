package com.meli.challenge.quasarfire.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class TopSecretSplitRequest {
    private double distance;
    private List<String> message;
}
