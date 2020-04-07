package de.wirvsvirus.coronicle;

import java.util.List;

import de.wirvsvirus.coronicle.db.model.InfectedPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoronicleService {

	@Autowired
	InfectedPointRepository infectedTraceRepository;

	public void saveInfectedTrace(List<InfectedPoint> trace) {
		infectedTraceRepository.saveAll(trace);
	}

	/**
	 * @param userTrace the trace to check against the database of infected traces
	 * @return true if there has been contact, false otherwise
	 */
	public boolean checkTrace(List<InfectedPoint> userTrace) {
		//Wo anders hinverschieben? wird erst später benötigt
		List<InfectedPoint> dataBaseTrace = infectedTraceRepository.findInfectedTracesByTimeGreaterThanEqual(userTrace.get(0).getTime());
		BoundingBox traceBox = BoundingBoxUtility.getBoundingBoxForTrace(dataBaseTrace);
		return InfectionChecker.check(userTrace, BoundingBoxUtility.filterByBoundingBox(dataBaseTrace, traceBox));
	}
}
