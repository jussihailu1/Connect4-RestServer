package nl.fhict.restserver.repository;

import nl.fhict.restserver.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player findByUsername(String username);
}
