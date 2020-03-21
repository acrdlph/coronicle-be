package de.wirvsvirus.coronicle;

import java.util.List;

import de.wirvsvirus.coronicle.db.model.InfectedTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoronicleRestController {

	@Autowired
	InfectedTraceRepository infectedTraceRepository;

	@PostMapping("/infectedtrace")
	public String saveTrace(@RequestBody List<InfectedTrace> traces) {
		infectedTraceRepository.saveAll(traces);
		return "OK";
	}

}
