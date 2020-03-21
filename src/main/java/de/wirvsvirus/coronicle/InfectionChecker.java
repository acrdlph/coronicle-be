package de.wirvsvirus.coronicle;

import de.wirvsvirus.coronicle.db.model.InfectedTrace;

import java.util.List;

public class InfectionChecker {

    //TODO: we need to specify this number!
    private static final double MAGIC_NUMBER = 10;

    //TODO: optimize
    public static boolean check(List<InfectedTrace> userTrace, List<InfectedTrace> dataBaseTrace) {
        for (InfectedTrace userLocation : userTrace) {
            for (InfectedTrace dataBaseLocation : dataBaseTrace) {
                if (wasInSameArea(userLocation, dataBaseLocation)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean wasInSameArea(InfectedTrace userLocation, InfectedTrace dataBaseLocation) {
        double deltaLat = Math.toRadians(userLocation.getLat() - dataBaseLocation.getLat());
        double deltaLon = Math.toRadians(userLocation.getLon() - dataBaseLocation.getLon());
        double alpha = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                Math.cos(Math.toRadians(userLocation.getLat())) * Math.cos(Math.toRadians(dataBaseLocation.getLat()))
                        * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(alpha), Math.sqrt(1 - alpha));
        double EARTH_RADIUS = 6371;
        return (EARTH_RADIUS * c * 1000) < MAGIC_NUMBER;
    }

}
