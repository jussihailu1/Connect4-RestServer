package nl.fhict.restserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import nl.fhict.restserver.model.Record;

public interface RecordRepository extends JpaRepository<Record, Integer> {
    Record findByPlayerId(int playerId);
}
