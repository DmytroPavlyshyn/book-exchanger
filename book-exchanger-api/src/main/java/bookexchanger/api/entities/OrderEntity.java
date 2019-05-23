package bookexchanger.api.entities;

public class OrderEntity {
    Integer clientId;
    Integer announceId;
    String comment;
    Boolean isActive;

    public OrderEntity() {
    }

    public OrderEntity(Integer clientID, Integer announceId, String comment, Boolean isActive) {
        this.clientId = clientID;
        this.announceId = announceId;
        this.comment = comment;
        this.isActive = isActive;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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
                "clientId=" + clientId +
                ", announceId=" + announceId +
                ", comment='" + comment + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
