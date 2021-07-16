package com.meli.challenge.quasarfire.service;

import com.meli.challenge.quasarfire.model.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SatelliteServiceTest {

    SatelliteService satelliteService;

    @BeforeEach
    void setUp() {
        satelliteService = new SatelliteService();
    }

    @Test
    void getLocation() {
        Location result = satelliteService.getLocation(new double[]{
                100,
                115.5,
                147.5
        });
        assertNotNull(result);
        assertNotNull(result.getX());
        assertNotNull(result.getY());
    }

    @Test
    void getMessage() {
        String result = satelliteService.getMessage(
                new String[][]{
                        {"este", "", "", "mensaje", ""},
                        {"", "es", "", "", "secreto"},
                        {"este", "", "un", "mensaje", ""}
                }
        );

        assertNotNull(result);
        assertEquals("este es un mensaje secreto", result);
    }
}