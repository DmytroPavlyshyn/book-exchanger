package bookexchanger.api.controller;

import bookexchanger.api.entities.AnnounceBoardEntity;
import bookexchanger.api.entities.BookEntity;
import bookexchanger.api.entities.UserAnnounceBookEntity;
import bookexchanger.api.entities.UserEntity;
import bookexchanger.api.models.AnnounceAddRequest;
import bookexchanger.api.models.AnnounceAddResponse;
import bookexchanger.api.models.AnnounceDataResponse;
import bookexchanger.api.repository.AnnounceBoardRepository;
import bookexchanger.api.repository.BookRepository;
import bookexchanger.api.repository.UserAnnounceBookRepository;
import bookexchanger.api.utils.UserTmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class AnnounceBoardController {


    @Autowired
    AnnounceBoardRepository announceBoardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserAnnounceBookRepository userAnnounceBookRepository;

    @GetMapping(value = "/api/announce")
    public ResponseEntity<List<AnnounceDataResponse>> getAllUsers() throws SQLException {
        List<UserAnnounceBookEntity> announceBoardEntities = userAnnounceBookRepository.selectAll();
        List<AnnounceDataResponse> announceDataResponses = new ArrayList<>();
        announceBoardEntities
                .stream()
                .filter(UserAnnounceBookEntity::getActive).forEach((a) -> {
            UserEntity u = a.getUserEntity();
            BookEntity b = a.getBookEntity();
            announceDataResponses.add(new AnnounceDataResponse(
                    a.getId(),
                    u.getFirstName(),
                    u.getSurname(),
                    b.getName(),
                    b.getGenre(),
                    b.getAuthor(),
                    b.getYear(),
                    a.getAnnounceTimeStamp()
            ));
        });
        return new ResponseEntity<>(announceDataResponses, HttpStatus.OK);
    }

    @PostMapping("/api/announce/add")
    public ResponseEntity register(@RequestBody AnnounceAddRequest request) throws Exception {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(request.getName());
        bookEntity.setGenre(request.getGenre());
        bookEntity.setYear(request.getYear());
        bookEntity.setDescription(request.getDescription());
        bookEntity.setAuthor(request.getAuthor());

        BookEntity insertedBook = bookRepository.insert(bookEntity);
        AnnounceBoardEntity announceBoardEntity = new AnnounceBoardEntity();
        announceBoardEntity.setUserId(new UserTmp().getUserId());
        announceBoardEntity.setBookId(insertedBook.getId());
        announceBoardEntity.setAnnounceTimestamp(LocalDateTime.now());

        AnnounceBoardEntity insertedAnnounce = announceBoardRepository.insert(announceBoardEntity);

        AnnounceAddResponse announceAddResponse = new AnnounceAddResponse();
        announceAddResponse.setId(insertedAnnounce.getId());

        return new ResponseEntity<>(announceAddResponse, HttpStatus.OK);
    }
    @GetMapping(value = "/api/announce/{id}")
    public ResponseEntity<UserAnnounceBookEntity> getAnnounce(@PathVariable Integer id) throws SQLException {
        UserAnnounceBookEntity entity = userAnnounceBookRepository.findById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);

    }

}
