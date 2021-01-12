package nl.fhict.restserver.controller;

import nl.fhict.restserver.dto.LoginDTO;
import nl.fhict.restserver.dto.ResponseDTO;
import nl.fhict.restserver.enums.Response;
import nl.fhict.restserver.service.LoginService;
import nl.fhict.restserver.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    PlayerService playerService;

    @PostMapping("login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        if (loginService.checkUsernameExists(loginDTO.username)) {
            if (loginService.checkUsernameAndPassword(loginDTO.username, loginDTO.password)) {
                return ResponseDTO.success(playerService.findPlayerId(loginDTO.username));
            } else {
                return ResponseDTO.send(Response.WRONG_CREDENTIALS);
            }
        } else {
            return ResponseDTO.send(Response.USERNAME_DOES_NOT_EXIST);
        }
    }

    @PostMapping(path = "register")
    public ResponseEntity<ResponseDTO> register(@RequestBody LoginDTO loginDTO) {
        if (!loginService.checkUsernameExists(loginDTO.username)) {
            loginService.registerPlayer(loginDTO.username, loginDTO.password);
            return ResponseDTO.success(playerService.findPlayerId(loginDTO.username));
        } else {
            return ResponseDTO.send(Response.USERNAME_IN_USE);
        }
    }
}
