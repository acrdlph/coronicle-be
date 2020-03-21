package de.wirvsvirus.coronicle;

import java.util.List;

import de.wirvsvirus.coronicle.db.model.InfectedPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoronicleRestController {

	@Autowired
	private CoronicleService coronicleService;

	/**
	 * Should be used to submit a GPS trace of infected persons.
	 */
	@PostMapping("/infectedtrace")
	public String saveTrace(@RequestBody List<InfectedPoint> trace) {
		coronicleService.saveInfectedTrace(trace);
		return "OK";
	}

	/**
	 * Checks the given trace against the database for contact to infected persons.
	 */
	@PostMapping("/checktrace")
	public Boolean checkTrace(@RequestBody List<InfectedPoint> trace) {
		return coronicleService.checkTrace(trace);
	}

}
