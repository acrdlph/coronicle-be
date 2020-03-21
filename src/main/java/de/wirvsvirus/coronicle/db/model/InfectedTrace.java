package de.wirvsvirus.coronicle.db.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "infectedtraces")
public class InfectedTrace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "time", nullable = false)
	private LocalDateTime time;

	@Column(name = "lat", nullable = false)
	private Double lat;

	@Column(name = "lon", nullable = false)
	private Double lon;

	public InfectedTrace() {
	}

	public InfectedTrace(LocalDateTime time, Double lat, Double lon) {
		this.time = time;
		this.lat = lat;
		this.lon = lon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof InfectedTrace)) {
			return false;
		}
		InfectedTrace that = (InfectedTrace) o;
		return id.equals(that.id) &&
				time.equals(that.time) &&
				lat.equals(that.lat) &&
				lon.equals(that.lon);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, time, lat, lon);
	}
}

