package nl.fhict.restserver.service;

import nl.fhict.restserver.enums.GameResult;
import nl.fhict.restserver.model.Player;
import nl.fhict.restserver.model.Record;
import nl.fhict.restserver.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RecordService {

    @Autowired
    private RecordRepository repo;

    public Record processGameResult(int userId, GameResult gameResult) {
        Record record = findByPlayerId(userId);

        switch (gameResult) {
            case WIN -> record.addWin();
            case DRAW -> record.addDraw();
            case LOSS -> record.addLoss();
        }

        repo.save(record);
        return record;
    }

    public void createRecord(Player player){
        Record record = new Record(player);
        repo.save(record);
    }

    public Record findByPlayerId(int playerId) {
        return repo.findByPlayerId(playerId);
    }

    public List<Record> findAll() {
        return repo.findAll();
    }
}
