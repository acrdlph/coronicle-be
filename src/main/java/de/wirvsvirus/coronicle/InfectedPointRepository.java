package de.wirvsvirus.coronicle;

import java.time.LocalDateTime;
import java.util.List;

import de.wirvsvirus.coronicle.db.model.InfectedPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfectedPointRepository extends CrudRepository<InfectedPoint, Long> {

	List<InfectedPoint> findInfectedTracesByTimeGreaterThanEqual(LocalDateTime time);
}