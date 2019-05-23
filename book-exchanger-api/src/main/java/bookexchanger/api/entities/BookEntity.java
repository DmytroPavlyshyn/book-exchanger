package bookexchanger.api.entities;

import java.time.LocalDate;

public class BookEntity {
    private Integer id;
    private String name;
    private String genre;
    private String description;
    private String author;
    private LocalDate year;

    public BookEntity() {
    }

    public BookEntity(Integer id, String name, String genre, String description, String author, LocalDate year) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.author = author;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "BookEntity{" +
                "clientId=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
