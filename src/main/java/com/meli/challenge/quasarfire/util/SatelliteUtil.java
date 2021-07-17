package com.meli.challenge.quasarfire.util;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.meli.challenge.quasarfire.model.Location;
import com.meli.challenge.quasarfire.model.Satellite;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;

public class SatelliteUtil {

    public static final String KENOBI_SATELLITE = "Kenobi";
    public static final String SKYWALKER_SATELLITE = "Skywalker";
    public static final String SATO_SATELLITE = "Sato";

    public static List<Satellite> getSatellites(){
        List<Satellite> satellites = new ArrayList<>();
        satellites.add(Satellite
                .builder()
                .name(KENOBI_SATELLITE)
                .location(Location.builder()
                        .x(-500)
                        .y(-200)
                        .build()
                ).build());
        satellites.add(Satellite
                .builder()
                .name(SKYWALKER_SATELLITE)
                .location(Location.builder()
                .x(100)
                .y(-100).build()
                ).build());
        satellites.add(Satellite
                .builder()
                .name(SATO_SATELLITE)
                .location(Location.builder()
                .x(500)
                .y(100).build())
                .build());
        return satellites;
    }

    public static Location getLocationByTrilateration(final double[][] positions,
                                                      final double[] distances){
        NonLinearLeastSquaresSolver solver = new NonLinearLeastSquaresSolver(
                new TrilaterationFunction(positions, distances),
                new LevenbergMarquardtOptimizer());
        LeastSquaresOptimizer.Optimum optimum = solver.solve();
        double[] centroid = optimum.getPoint().toArray();
        return Location.builder()
                .x(centroid[0])
                .y(centroid[1])
                .build();
    }

}
