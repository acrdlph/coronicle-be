package de.wirvsvirus.coronicle;


import de.wirvsvirus.coronicle.db.model.InfectedPoint;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BoundingBoxUtility {
    private BoundingBoxUtility() {}

    private static final double RANGE_EPSILON = 5;

    public static BoundingBox getBoundingBoxForTrace(List<InfectedPoint> trace) {
        double maxlat = trace.stream().max(Comparator.comparing(InfectedPoint::getLat)).get().getLat();
        double minlat = trace.stream().min(Comparator.comparing(InfectedPoint::getLat)).get().getLat();

        double maxlon = trace.stream().max(Comparator.comparing(InfectedPoint::getLon)).get().getLon();
        double minlon = trace.stream().min(Comparator.comparing(InfectedPoint::getLon)).get().getLon();

        return new BoundingBox(minlon, maxlon, minlat, maxlat);
    }

    public static List<InfectedPoint> filterByBoundingBox(List<InfectedPoint> trace, BoundingBox box) {
        return trace.stream().filter((InfectedPoint t) ->  {
            return t.getLat() - box.getMinLat() >= -RANGE_EPSILON
                    && t.getLat() - box.getMaxLat() <= RANGE_EPSILON
                    && t.getLon() - box.getMinLon() >= -RANGE_EPSILON
                    && t.getLon() - box.getMaxLon() <= RANGE_EPSILON;
        }).collect(Collectors.toList());
    }
}
