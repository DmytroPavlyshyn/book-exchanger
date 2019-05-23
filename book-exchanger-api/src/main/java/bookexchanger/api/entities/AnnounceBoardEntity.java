package bookexchanger.api.entities;

import java.time.LocalDateTime;

public class AnnounceBoardEntity {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private LocalDateTime announceTimestamp;
    private Boolean isActive;
    public AnnounceBoardEntity() {
    }

    public AnnounceBoardEntity(Integer id, Integer userId, Integer bookId, LocalDateTime announceTimestamp, Boolean isActive) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.announceTimestamp = announceTimestamp;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public LocalDateTime getAnnounceTimestamp() {
        return announceTimestamp;
    }

    public void setAnnounceTimestamp(LocalDateTime announceTimestamp) {
        this.announceTimestamp = announceTimestamp;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "AnnounceBoardEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", announceTimestamp=" + announceTimestamp +
                '}';
    }
}
