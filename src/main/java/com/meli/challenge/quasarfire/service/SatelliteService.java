package com.meli.challenge.quasarfire.service;

import com.meli.challenge.quasarfire.model.Location;
import com.meli.challenge.quasarfire.model.Satellite;
import com.meli.challenge.quasarfire.util.SatelliteUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class SatelliteService {

    public Location getLocation(final double... distances){
        List<Satellite> satellites = SatelliteUtil.getSatellites();
        return SatelliteUtil.getLocationByTrilateration(
                satellites.stream()
                        .map(satellite -> new double[] { satellite
                                .getLocation()
                                .getX(), satellite
                                .getLocation()
                                .getY()}
                        )
                        .toArray(double[][]::new), distances);
    }

    public String getMessage(final String[]... messages){
        Map<Integer,String> messageCompleted = new HashMap<>();
        IntStream.range(0, messages[0].length)
            .forEach(column ->
                IntStream.range(0, messages.length)
                    .forEach(row -> {
                        if(!messages[row][column].isEmpty()){
                            messageCompleted.put(column, messages[row][column]);
                        }
                    }
            ));
        return String.join(" ", messageCompleted.values());
    }

}
