package de.wirvsvirus.coronicle;

public final class BoundingBox {
    private double minLon;
    private double maxLon;
    private double minLat;
    private double maxLat;

    public BoundingBox(double minLon, double maxLon, double minLat, double maxLat) {
        this.minLon = minLon;
        this.maxLon = maxLon;
        this.minLat = minLat;
        this.maxLat = maxLat;
    }

    public double getMaxLat() {
        return maxLat;
    }

    public double getMinLat() {
        return minLat;
    }

    public double getMaxLon() {
        return maxLon;
    }

    public double getMinLon() {
        return minLon;
    }

}
