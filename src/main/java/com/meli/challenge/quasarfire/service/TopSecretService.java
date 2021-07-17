package com.meli.challenge.quasarfire.service;

import com.meli.challenge.quasarfire.exception.NotEnoughInformationException;
import com.meli.challenge.quasarfire.model.*;
import com.meli.challenge.quasarfire.util.SatelliteUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TopSecretService {

    private static final int NUMBER_OF_SATELLITES = 3;
    private final SatelliteService satelliteService;
    private Map<String, SatelliteRequest> satellites;

    public TopSecretResponse topSecret(final TopSecretRequest topSecretRequest) {
        return TopSecretResponse.builder()
                .position(getPosition(topSecretRequest.getSatellites()))
                .message(getMessage(topSecretRequest.getSatellites()))
                .build();
    }

    private Location getPosition(final List<SatelliteRequest> satellites) {
        return satelliteService.getLocation(
                satellites.stream()
                        .filter(satellite -> satellite.getName().equalsIgnoreCase(SatelliteUtil.KENOBI_SATELLITE))
                        .findFirst().get().getDistance(),
                satellites.stream()
                        .filter(satellite -> satellite.getName().equalsIgnoreCase(SatelliteUtil.SKYWALKER_SATELLITE))
                        .findFirst().get().getDistance(),
                satellites.stream()
                        .filter(satellite -> satellite.getName().equalsIgnoreCase(SatelliteUtil.SATO_SATELLITE))
                        .findFirst().get().getDistance()
        );
    }

    private String getMessage(final List<SatelliteRequest> satellites) {
        return satelliteService.getMessage(
                satellites
                        .stream()
                        .map(satellite -> satellite.getMessage().toArray(String[]::new))
                        .toArray(String[][]::new));
    }

    public void topSecretSplit(String satelliteName, TopSecretSplitRequest topSecretSplitRequest) {
        satellites.put(satelliteName,
                SatelliteRequest
                        .builder()
                        .name(satelliteName)
                        .distance(topSecretSplitRequest.getDistance())
                        .message(topSecretSplitRequest.getMessage())
                        .build()
        );
    }

    public void deleteTopSecretSplit() {
        satellites.clear();
    }

    public TopSecretResponse getTopSecretSplit() {
        if(satellites.isEmpty() || satellites.size() < NUMBER_OF_SATELLITES){
            throw new NotEnoughInformationException("Not enough information for calculate location");
        }
        return topSecret(TopSecretRequest
                .builder()
                .satellites(satellites.values().stream().collect(Collectors.toList()))
                .build());
    }
}
