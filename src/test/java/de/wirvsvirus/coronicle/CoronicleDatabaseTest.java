package de.wirvsvirus.coronicle;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import de.wirvsvirus.coronicle.db.model.InfectedPoint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class CoronicleDatabaseTest {

	@Autowired
	private InfectedPointRepository infectedTraceRepository;

	@Test
	public void saveAndRetrieveInfectedTrace() {

		Instant now = Instant.now();
		LocalDateTime timestamp = LocalDateTime.ofInstant(now, ZoneOffset.UTC);
		InfectedPoint infectedTrace = new InfectedPoint(timestamp, 45.5, 13.5);
		infectedTraceRepository.save(infectedTrace);

		List<InfectedPoint> retrievedTraces = infectedTraceRepository.findInfectedTracesByTimeGreaterThanEqual(timestamp);

		assertNotNull(retrievedTraces);
		assertEquals(1, retrievedTraces.size());
	}
}
