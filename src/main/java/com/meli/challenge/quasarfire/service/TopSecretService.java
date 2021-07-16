package com.meli.challenge.quasarfire.service;

import com.meli.challenge.quasarfire.model.Location;
import com.meli.challenge.quasarfire.model.SatelliteRequest;
import com.meli.challenge.quasarfire.model.TopSecretRequest;
import com.meli.challenge.quasarfire.model.TopSecretResponse;
import com.meli.challenge.quasarfire.util.SatelliteUtil;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TopSecretService {

    private final SatelliteService satelliteService;

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
}
