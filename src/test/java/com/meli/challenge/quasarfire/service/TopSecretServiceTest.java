package com.meli.challenge.quasarfire.service;

import com.meli.challenge.quasarfire.exception.NotEnoughInformationException;
import com.meli.challenge.quasarfire.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class TopSecretServiceTest {

    @Mock
    SatelliteService satelliteService;

    @InjectMocks
    TopSecretService topSecretService;

    List<SatelliteRequest> satellites = new ArrayList<>();
    Location expectedLocation;
    String expectedMessage;

    @BeforeEach
    void setUp() {
        satellites.add(SatelliteRequest.builder()
                .name("kenobi")
                .distance(123)
                .message(new ArrayList<>())
                .build());
        satellites.add(SatelliteRequest.builder()
                .name("skywalker")
                .distance(124)
                .message(new ArrayList<>())
                .build());
        satellites.add(SatelliteRequest.builder()
                .name("sato")
                .distance(125)
                .message(new ArrayList<>())
                .build());
        expectedMessage = "message";
        expectedLocation = Location.builder()
                .x(1)
                .y(2)
                .build();
    }

    @Test
    void topSecret() {
        when(satelliteService.getLocation(any())).thenReturn(expectedLocation);
        when(satelliteService.getMessage(any())).thenReturn(expectedMessage);
        TopSecretResponse result = topSecretService.topSecret(TopSecretRequest
                .builder()
                .satellites(satellites)
                .build());
        assertNotNull(result);
        assertEquals(expectedLocation, result.getPosition());
        assertEquals(expectedMessage, result.getMessage());
    }
}