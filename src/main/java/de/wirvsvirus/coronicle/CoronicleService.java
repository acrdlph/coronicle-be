package de.wirvsvirus.coronicle;

import java.util.List;

import de.wirvsvirus.coronicle.db.model.InfectedTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoronicleService {

	@Autowired
	InfectedTraceRepository infectedTraceRepository;

	public void saveInfectedTrace(List<InfectedTrace> trace) {
		infectedTraceRepository.saveAll(trace);
	}

	/**
	 * @param trace the trace to check against the database of infected traces
	 * @return true if there has been contact, false otherwise
	 */
	public boolean checkTrace(List<InfectedTrace> trace) {
		// TODO implement this
		return false;
	}
}
