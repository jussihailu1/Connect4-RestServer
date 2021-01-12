package nl.fhict.restserver.service;

import nl.fhict.restserver.model.Player;
import nl.fhict.restserver.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private RecordService recordService;

    public void createPlayer(String username, String password) {
        Player p = new Player(username, password);
        playerRepository.save(p);
        p = findByUsername(username);
        recordService.createRecord(p);
    }

    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    public Player findByUsername(String username) {
        return playerRepository.findByUsername(username);
    }

    public int findPlayerId(String username) {
        return findByUsername(username).getId();
    }
}
