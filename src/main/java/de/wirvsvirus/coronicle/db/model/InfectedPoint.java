package de.wirvsvirus.coronicle.db.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "infectedtraces")
public class InfectedPoint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "timestamp", nullable = false)
	private LocalDateTime time;

	@Column(name = "lat", nullable = false)
	private double lat;

	@Column(name = "lng", nullable = false)
	private double lng;

	public InfectedPoint() {
	}

	public InfectedPoint(LocalDateTime time, Double lat, Double lng) {
		this.time = time;
		this.lat = lat;
		this.lng = lng;
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

	public void setTime(LocalDateTime timestamp) {
		this.time = timestamp;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lon) {
		this.lng = lon;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof InfectedPoint)) return false;
		InfectedPoint that = (InfectedPoint) o;
		return id == that.id &&
				Double.compare(that.lat, lat) == 0 &&
				Double.compare(that.lng, lng) == 0 &&
				Objects.equals(time, that.time);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, time, lat, lng);
	}
}

