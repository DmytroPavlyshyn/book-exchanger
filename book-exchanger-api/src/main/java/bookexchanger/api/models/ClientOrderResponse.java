package bookexchanger.api.models;

public class ClientOrderResponse {
      Integer clientId;
      String firstName;
      String surname;
      Integer announceId;
      String comment;

    public ClientOrderResponse() {
    }

    public ClientOrderResponse(Integer clientId, String firstName, String surname, Integer announceId, String comment) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.surname = surname;
        this.announceId = announceId;
        this.comment = comment;
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

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}
