package nl.fhict.restserver.controller;

import nl.fhict.restserver.dto.RecordDTO;
import nl.fhict.restserver.dto.ResponseDTO;
import nl.fhict.restserver.model.Record;
import nl.fhict.restserver.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("record")
@CrossOrigin(origins = "*")
public class RecordController {

    @Autowired
    RecordService service;

    @PutMapping
    public ResponseEntity<ResponseDTO> updateRecord(@RequestBody RecordDTO recordDTO) {
        Record record = service.processGameResult(recordDTO.playerId, recordDTO.gameResult);
        return ResponseDTO.success(record);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> findRecordByPlayerId(@PathVariable Integer id) {
        Record record = service.findByPlayerId(id);
        return ResponseDTO.success(record);
    }

    @GetMapping()
    public ResponseEntity<ResponseDTO> findAll() {
        return ResponseDTO.success(service.findAll());
    }
}
