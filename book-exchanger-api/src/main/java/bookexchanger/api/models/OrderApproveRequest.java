package bookexchanger.api.models;

public class OrderApproveRequest {
    Integer clientId;
    Integer announceId;

    public OrderApproveRequest() {
    }

    public OrderApproveRequest(Integer clientId, Integer announceId) {
        this.clientId = clientId;
        this.announceId = announceId;
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

    @Override
    public String toString() {
        return "OrderApproveRequest{" +
                "clientId=" + clientId +
                ", announceId=" + announceId +
                '}';
    }
}
