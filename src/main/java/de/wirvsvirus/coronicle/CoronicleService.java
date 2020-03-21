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
	 * @param userTrace the trace to check against the database of infected traces
	 * @return true if there has been contact, false otherwise
	 */
	public boolean checkTrace(List<InfectedTrace> userTrace) {
		//Wo anders hinverschieben? wird erst später benötigt
		List<InfectedTrace> dataBaseTrace = infectedTraceRepository.findInfectedTracesByTimeGreaterThanEqual(userTrace.get(0).getTime());
		return InfectionChecker.check(userTrace, dataBaseTrace);
	}
}
