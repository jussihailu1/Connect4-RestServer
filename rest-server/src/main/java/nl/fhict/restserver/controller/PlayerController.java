package nl.fhict.restserver.controller;

import nl.fhict.restserver.dto.ResponseDTO;
import nl.fhict.restserver.model.Player;
import nl.fhict.restserver.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("player")
@CrossOrigin(origins = "*")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllPlayers() {
        return ResponseDTO.success(playerService.findAllPlayers());
    }
}
