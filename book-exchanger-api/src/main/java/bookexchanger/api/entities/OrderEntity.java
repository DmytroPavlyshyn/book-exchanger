package bookexchanger.api.entities;

public class OrderEntity {
    Integer id;
    Integer announceId;
    String comment;
    Boolean isActive;

    public OrderEntity() {
    }

    public OrderEntity(Integer id, Integer announceId, String comment, Boolean isActive) {
        this.id = id;
        this.announceId = announceId;
        this.comment = comment;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnnounceId() {
        return announceId;
    }

    public void setAnnounceId(Integer announceId) {
        this.announceId = announceId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", announceId=" + announceId +
                ", comment='" + comment + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
