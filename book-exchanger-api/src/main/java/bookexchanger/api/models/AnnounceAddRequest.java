package bookexchanger.api.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AnnounceAddRequest {
    private String name;
    private String genre;
    private String description;
    private String author;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate year;

    public AnnounceAddRequest() {
    }

    public AnnounceAddRequest(String name, String genre, String description, String author, LocalDate year) {
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
