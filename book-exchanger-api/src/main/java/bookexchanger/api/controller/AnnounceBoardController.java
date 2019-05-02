package bookexchanger.api.controller;

import bookexchanger.api.entities.AnnounceBoardEntity;
import bookexchanger.api.models.AnnounceAddRequest;
import bookexchanger.api.models.AnnounceAddResponse;
import bookexchanger.api.repository.impl.AnnounceBoardRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
public class AnnounceBoardController {
    @Autowired
    AnnounceBoardRepositoryImpl announceBoardRepository;


    @GetMapping(value = "/api/announce")
    public ResponseEntity<List<AnnounceBoardEntity>> getAllUsers() throws SQLException {
        List<AnnounceBoardEntity> announceBoardEntities = announceBoardRepository.selectAll();
        return new ResponseEntity<>(announceBoardEntities, HttpStatus.OK);
    }

    @PostMapping("/api/announce/add")
    public ResponseEntity register(@RequestBody AnnounceAddRequest request) throws Exception {
        AnnounceBoardEntity announceBoardEntity = new AnnounceBoardEntity();
        announceBoardEntity.setBookId(request.getBookId());
        announceBoardEntity.setUserId(request.getUserId());
        announceBoardEntity.setAnnounceTimestamp(LocalDateTime.now());
        AnnounceBoardEntity insertedAnnounceBoardEntity = announceBoardRepository.insert(announceBoardEntity);
        AnnounceAddResponse regResponse = new AnnounceAddResponse();
        regResponse.setId(insertedAnnounceBoardEntity.getId());
        return new ResponseEntity<>(regResponse, HttpStatus.OK);
    }

}
