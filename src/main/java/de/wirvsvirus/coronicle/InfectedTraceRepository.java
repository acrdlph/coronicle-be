package de.wirvsvirus.coronicle;

import java.time.LocalDateTime;
import java.util.List;

import de.wirvsvirus.coronicle.db.model.InfectedTrace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfectedTraceRepository extends CrudRepository<InfectedTrace, Long> {

	List<InfectedTrace> findInfectedTracesByTimeGreaterThanEqual(LocalDateTime time);
}
