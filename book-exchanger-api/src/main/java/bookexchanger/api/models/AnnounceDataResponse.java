package bookexchanger.api.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnnounceDataResponse {
    private Integer id;
    private String firstName;
    private String surname;
    private String bookName;
    private String bookGenre;
    private String author;
    private LocalDate year;
    private LocalDateTime announceTimestamp;

    public AnnounceDataResponse() {
    }

    public AnnounceDataResponse(Integer id, String firstName, String surname, String bookName, String bookGenre, String author, LocalDate year, LocalDateTime announceTimestamp) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.bookName = bookName;
        this.bookGenre = bookGenre;
        this.author = author;
        this.year = year;
        this.announceTimestamp = announceTimestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public LocalDateTime getAnnounceTimestamp() {
        return announceTimestamp;
    }

    public void setAnnounceTimestamp(LocalDateTime announceTimestamp) {
        this.announceTimestamp = announceTimestamp;
    }
}
