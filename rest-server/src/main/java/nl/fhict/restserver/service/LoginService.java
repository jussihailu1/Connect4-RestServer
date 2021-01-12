package nl.fhict.restserver.service;

import nl.fhict.restserver.model.Player;
import nl.fhict.restserver.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LoginService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    public boolean checkUsernameExists(String username) {
        return playerService.findByUsername(username) != null;
    }

    public boolean checkUsernameAndPassword(String username, String password) {
        Player player = playerService.findByUsername(username);
        return player.getPassword().equals(password);
    }

    public void registerPlayer(String username, String password) {
        playerService.createPlayer(username, password);
    }
}
