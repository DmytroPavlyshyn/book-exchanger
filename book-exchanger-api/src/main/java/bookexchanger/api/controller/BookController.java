package bookexchanger.api.controller;

import bookexchanger.api.entities.BookEntity;
import bookexchanger.api.models.BookData;
import bookexchanger.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class BookController {
    @Autowired
    BookRepository announceBoardRepository;


    @GetMapping(value = "/api/book")
    public ResponseEntity<List<BookData>> getAllUsers() throws SQLException {
        List<BookEntity> bookEntities = announceBoardRepository.selectAll();
        List<BookData> bookData = new ArrayList<>();
        bookEntities.forEach((e) -> {
            bookData.add(new BookData(e.getName(), e.getGenre(), e.getDescription(), e.getAuthor(), e.getYear()));
        });
        return new ResponseEntity<>(bookData, HttpStatus.OK);
    }


}
