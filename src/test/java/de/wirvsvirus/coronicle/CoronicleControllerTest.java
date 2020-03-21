package de.wirvsvirus.coronicle;

import java.net.URI;
import java.time.LocalDateTime;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CoronicleControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testPostTrace() {
		List<InfectedTrace> infectedTraces = Collections.singletonList(new InfectedTrace(LocalDateTime.now(), 45.5, 13.5));
		HttpEntity<List<InfectedTrace>> entity = new HttpEntity<>(infectedTraces);
		ResponseEntity<String> response = restTemplate.exchange(URI.create("http://localhost:"
				+ port
				+ "/infectedtrace"), HttpMethod.POST, entity, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
	}

}
