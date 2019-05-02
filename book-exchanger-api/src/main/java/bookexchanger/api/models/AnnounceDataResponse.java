package bookexchanger.api.models;

import java.time.LocalDateTime;

public class AnnounceDataResponse {
    private Integer id;
    private String user;
    private String book;
    private LocalDateTime announceTimestamp;

    public AnnounceDataResponse(Integer id, String user, String book, LocalDateTime announceTimestamp) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.announceTimestamp = announceTimestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public LocalDateTime getAnnounceTimestamp() {
        return announceTimestamp;
    }

    public void setAnnounceTimestamp(LocalDateTime announceTimestamp) {
        this.announceTimestamp = announceTimestamp;
    }
}
