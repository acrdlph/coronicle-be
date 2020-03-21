package de.wirvsvirus.coronicle.db.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "infectedtraces")
public class InfectedTrace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "time", nullable = false)
	private LocalDateTime time;

	@Column(name = "lat", nullable = false)
	private double lat;

	@Column(name = "lon", nullable = false)
	private double lon;

	public InfectedTrace() {
	}

	public InfectedTrace(LocalDateTime time, Double lat, Double lon) {
		this.time = time;
		this.lat = lat;
		this.lon = lon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof InfectedTrace)) return false;
		InfectedTrace that = (InfectedTrace) o;
		return id == that.id &&
				Double.compare(that.lat, lat) == 0 &&
				Double.compare(that.lon, lon) == 0 &&
				Objects.equals(time, that.time);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, time, lat, lon);
	}
}

