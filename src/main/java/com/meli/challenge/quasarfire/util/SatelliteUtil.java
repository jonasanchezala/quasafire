package com.meli.challenge.quasarfire.util;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.meli.challenge.quasarfire.model.Location;
import com.meli.challenge.quasarfire.model.Satellite;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SatelliteUtil {
    public static List<Satellite> getSatellites(){
        List<Satellite> satellites = new ArrayList<>();
        satellites.add(Satellite
                .builder()
                .name("Kenobi")
                .location(Location.builder()
                        .x(-500)
                        .y(-200)
                        .build()
                ).build());
        satellites.add(Satellite
                .builder()
                .name("Skywalker")
                .location(Location.builder()
                .x(100)
                .y(-100).build()
                ).build());
        satellites.add(Satellite
                .builder()
                .name("Sato")
                .location(Location.builder()
                .x(500)
                .y(100).build())
                .build());
        return satellites;
    }

    public static Location getLocationByTrilateration(double[][] positions,
                                                      double[] distances
){
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

    public static float getRoundedDecimal(final float number){
        return Math.round(number * 100.0)/100.0f;
    }

}
