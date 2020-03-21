package de.wirvsvirus.coronicle;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;
import java.util.List;

import de.wirvsvirus.coronicle.db.model.InfectedTrace;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CoronicleControllerTest {

	public static final LocalDateTime DATE_1 = LocalDateTime.of(2020, Month.MARCH, 21, 12, 0, 0);

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testPostTrace() {
		String baseUrl = "http://localhost:" + port;

		List<InfectedTrace> infectedTraces = Collections.singletonList(new InfectedTrace(DATE_1, 45.5, 13.5));
		HttpEntity<List<InfectedTrace>> infectedEntity = new HttpEntity<>(infectedTraces);
		ResponseEntity<String> response = restTemplate.exchange(URI.create(baseUrl
				+ "/infectedtrace"), HttpMethod.POST, infectedEntity, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("OK", response.getBody());

		ResponseEntity<Boolean> checkResponse = restTemplate.exchange(URI.create(baseUrl
				+ "/checktrace"), HttpMethod.POST, infectedEntity, Boolean.class);

		assertEquals(HttpStatus.OK, checkResponse.getStatusCode());
		assertNotNull(checkResponse.getBody());

		// FIXME
		// assertTrue(checkResponse.getBody());
	}

}
